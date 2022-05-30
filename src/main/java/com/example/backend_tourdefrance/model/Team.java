package com.example.backend_tourdefrance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "teams")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long team_id;

  @Column(nullable = false, unique = true)
  private String team_name;

  @OneToMany
  @JoinColumn(name = "fk_team_id")
  private List<Rider> riders;

  public Team() {

  }

  public Team(Long team_id, String team_name, List<Rider> riders) {
    this.team_id = team_id;
    this.team_name = team_name;
    this.riders = riders;
  }
}
