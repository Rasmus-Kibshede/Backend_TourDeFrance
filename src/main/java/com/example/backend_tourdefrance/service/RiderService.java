package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Rider;
import com.example.backend_tourdefrance.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class RiderService {

  @Autowired
  private RiderRepository riderRepository;

  public List<Rider> findAllRiders() {
    return riderRepository.findAll();
  }

  public void saveRider(Rider rider) {
    riderRepository.save(rider);
  }


  public Rider findRiderById(Long id) {
    Optional<Rider> rider = riderRepository.findById(id);

    return rider.isPresent() ? rider.get() : null;
  }


  public void deleteRiderById(Long id) {
    riderRepository.deleteById(id);
  }

  public List<Rider> findAllRidersByTeamId(Long id) {
    return riderRepository.findAllRiderByTeamTeam_id(id);
  }

  public HashMap<String, Rider> findBestRiders() {
    List<Rider> riders = findAllRiders();
    HashMap<String, Rider> riderHashMap = new HashMap<>();

    Rider mountainShirt = null;
    Rider greenShirt = null;
    Rider yellowShirt = null;
    Rider whiteShirt = null;

    for (Rider rider : riders) {

      //Mountain shirt
      if (mountainShirt == null || rider.getRider_mountain_point() > mountainShirt.getRider_mountain_point()) {
        mountainShirt = rider;
      }

      //Sprint shirt aka green shirt
      if (greenShirt == null || rider.getRider_sprint_point() > greenShirt.getRider_sprint_point()) {
        greenShirt = rider;
      }

      //Yellow shirt
      if (yellowShirt == null ||rider.getRider_time() < yellowShirt.getRider_time()) {
        yellowShirt = rider;
      }

      int riderAge = Year.now().getValue() - Integer.parseInt(rider.getRider_birthday().toString().split("-")[0]);

      //White shirt
      if (riderAge < 26 && (whiteShirt == null || rider.getRider_time() < whiteShirt.getRider_time())) {
        whiteShirt = rider;
      }
    }

    riderHashMap.put("mountainShirt", mountainShirt);
    riderHashMap.put("greenShirt", greenShirt);
    riderHashMap.put("yellowShirt", yellowShirt);
    riderHashMap.put("whiteShirt", whiteShirt);

    return riderHashMap;
  }
}
