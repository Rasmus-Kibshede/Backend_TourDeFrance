package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Rider;
import com.example.backend_tourdefrance.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
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

  public List<Rider> findAllRidersOrderByTime() {
    return riderRepository.findAllOrderByRider_time();
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
      mountainShirt = shirtSortMountain(rider, mountainShirt);

      //Sprint shirt aka green shirt
      greenShirt = shirtSortGreen(rider, greenShirt);


      //Yellow shirt
      yellowShirt = shirtSortTime(rider, yellowShirt);

      int riderAge = calculateRiderAge(rider);

      //White shirt
      whiteShirt = shirtSortWhite(riderAge, rider, whiteShirt);
    }

    riderHashMap.put("mountainShirt", mountainShirt);
    riderHashMap.put("greenShirt", greenShirt);
    riderHashMap.put("yellowShirt", yellowShirt);
    riderHashMap.put("whiteShirt", whiteShirt);

    return riderHashMap;
  }

  public int calculateRiderAge(Rider rider){
    return Year.now().getValue() - Integer.parseInt(rider.getRider_birthday().toString().split("-")[0]);
  }

  public Rider shirtSortWhite(int riderAge, Rider rider, Rider shirt) {
    if (riderAge < 26 && (shirt == null || rider.getRider_time() < shirt.getRider_time())) {
      return rider;
    }
    return shirt;
  }

  public Rider shirtSortGreen(Rider rider, Rider shirt) {
    if (shirt == null || rider.getRider_sprint_point() > shirt.getRider_sprint_point()) {
      return rider;
    }
    return shirt;
  }

  public Rider shirtSortMountain(Rider rider, Rider shirt) {
    if (shirt == null || rider.getRider_mountain_point() > shirt.getRider_mountain_point()) {
      return rider;
    }
    return shirt;
  }

  public Rider shirtSortTime(Rider rider, Rider shirt) {
    if (shirt == null || rider.getRider_time() < shirt.getRider_time()) {
      return rider;
    }
    return shirt;
  }


}
