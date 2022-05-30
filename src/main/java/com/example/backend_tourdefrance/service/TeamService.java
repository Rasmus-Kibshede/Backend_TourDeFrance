package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Team;
import com.example.backend_tourdefrance.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

  @Autowired
  private TeamRepository teamRepository;

  public Team saveTeam(Team team) {
    return teamRepository.save(team);
  }

  public List<Team> findAllTeams() {
    return teamRepository.findAll();
  }

  public Team findTeamById(Long id) {
    Optional<Team> team = teamRepository.findById(id);

    return team.isPresent() ? team.get() : null;
  }

  public void deleteTeamById(Long id) {
    teamRepository.deleteById(id);
  }
}
