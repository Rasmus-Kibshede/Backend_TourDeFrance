package com.example.backend_tourdefrance.repository;

import com.example.backend_tourdefrance.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {

  @Query("SELECT r FROM Rider r WHERE r.team.team_id = ?1")
  List<Rider> findAllRiderByTeamTeam_id(Long id);

  /*@Query("SELECT r FROM Rider r WHERE r.rider_mountain_point = (SELECT MAX(rider_mountain_point) from Rider)")
  Rider findRiderWithMaxMountainPoints();

  @Query("SELECT r FROM Rider r WHERE r.rider_sprint_point = (SELECT MAX(rider_sprint_point) from Rider)")
  Rider findRiderWithMaxSprintPoints();*/

}
