package com.example.backend_tourdefrance.controller;


import com.example.backend_tourdefrance.model.Team;
import com.example.backend_tourdefrance.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TeamRESTController {

  @Autowired
  private TeamService teamService;

  @GetMapping("/teams")
  public List<Team> getAllTeams() {
    return teamService.findAllTeams();
  }

  @GetMapping("/team/{id}")
  public Team getAllTeams(@PathVariable Long id) {
    return teamService.findTeamById(id);
  }

  @PostMapping("/team")
  @ResponseStatus(HttpStatus.CREATED)
  public Team addNewTeam(@RequestBody Team team) {
    return teamService.saveTeam(team);
  }

  /*@PutMapping("/team")
  @ResponseStatus(HttpStatus.CREATED)
  public Team updateTeam(@RequestBody Team team) {
    return teamService.saveTeam(team);
  }*/

  @DeleteMapping("/team/{id}")
  public ResponseEntity<String> deleteTeam(@PathVariable Long id) {

    if (teamService.findTeamById(id) != null) {
      teamService.deleteTeamById(id);
      return new ResponseEntity<>("Team with id = " + id + " has been deleted", HttpStatus.OK);
    }
    return new ResponseEntity<>("Couldn't find team with id = " + id, HttpStatus.NOT_FOUND);
  }


}
