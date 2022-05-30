package com.example.backend_tourdefrance.controller;

import com.example.backend_tourdefrance.model.Rider;
import com.example.backend_tourdefrance.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class RiderRESTController {

  @Autowired
  private RiderService riderService;


  @GetMapping("/riders")
  public List<Rider> getAllRiders() {
    List<Rider> riders = riderService.findAllRiders();
    return riders;
  }

  @GetMapping("/shirts/riders")
  public HashMap<String, Rider> getShirtsRiders() {
    return riderService.findBestRiders();
  }

  @GetMapping("/riders/team/{id}")
  public List<Rider> getAllRidersByTeam(@PathVariable Long id) {
    return riderService.findAllRidersByTeamId(id);
  }

  @GetMapping("/rider/{id}")
  public Rider getRider(@PathVariable Long id) {
    return riderService.findRiderById(id);
  }

  @PostMapping("/rider")
  public ResponseEntity<String> addNewRider(@RequestBody Rider rider) {

    String response = "Rider " + rider.getRider_firstname() + " " + (rider.getRider_middlename() != null ? rider.getRider_middlename() : "") + " " + rider.getRider_lastname();

    if (rider.getRider_id() == null || riderService.findRiderById(rider.getRider_id()) == null) {
      riderService.saveRider(rider);
      return new ResponseEntity<>(response + " has been created", HttpStatus.CREATED);
    } else {
      riderService.saveRider(rider);
      return new ResponseEntity<>(response + " has been updated", HttpStatus.OK);
    }
  }

  @DeleteMapping("/rider/{id}")
  public ResponseEntity<String> deleteRider(@PathVariable Long id) {

    if (riderService.findRiderById(id) != null) {
      riderService.deleteRiderById(id);
      return new ResponseEntity<>("Rider with id = " + id + " has been deleted", HttpStatus.OK);
    }
    return new ResponseEntity<>("Couldn't find rider with id = " + id, HttpStatus.NOT_FOUND);
  }


}
