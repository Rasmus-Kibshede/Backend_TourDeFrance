package com.example.backend_tourdefrance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "riders")
public class Rider {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rider_id;

  @Column(nullable = false)
  private String rider_firstname;

  @Column(nullable = true)
  private String rider_middlename;

  @Column(nullable = false)
  private String rider_lastname;

  @Column(nullable = false)
  private String rider_country;

  @Column(nullable = false)
  private Double rider_weight;

  @Column(nullable = false)
  private Double rider_height;

  @Column(nullable = false)
  private Date rider_birthday;

  @Column(nullable = false)
  private Boolean rider_leader;

  @Column(nullable = false)
  private double rider_time;

  @Column(nullable = false)
  private int rider_mountain_point;

  @Column(nullable = false)
  private int rider_sprint_point;

  @ManyToOne
  @JoinColumn(name = "fk_team_id")
  @JsonBackReference(value = "team_JB")
  private Team team;

  public Rider() {

  }

  public Rider(Long rider_id, String rider_firstname, String rider_lastname, String rider_country, Double rider_weight, Double rider_height, Date rider_birthday, Boolean rider_leader, double rider_time, int rider_mountain_point, int rider_sprint_point, Team team) {
    this.rider_id = rider_id;
    this.rider_firstname = rider_firstname;
    this.rider_lastname = rider_lastname;
    this.rider_country = rider_country;
    this.rider_weight = rider_weight;
    this.rider_height = rider_height;
    this.rider_birthday = rider_birthday;
    this.rider_leader = rider_leader;
    this.rider_time = rider_time;
    this.rider_mountain_point = rider_mountain_point;
    this.rider_sprint_point = rider_sprint_point;
    this.team = team;
  }
}
