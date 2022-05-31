package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Rider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RiderServiceTest {

  private RiderService riderService = new RiderService();

  Rider shirt = null;
  Rider shirtNotNull = null;
  Rider rider = null;

  @BeforeEach
  public void setUp() {
    rider = new Rider(Long.parseLong("1"), "t", "t", "t", 12.0, 12.0, new Date(), false, 12, 60, 60, null);
    shirtNotNull = new Rider(Long.parseLong("1"), "t", "t", "t", 12.0, 12.0, new Date(), false, 20, 40, 40, null);
  }

  @Test
  public void mountainShirtSortFindHighestWithNull() {
    Rider expected = riderService.shirtSortMountain(rider, shirt);

    assertEquals(expected, rider);
  }

  @Test
  public void mountainShirtSortFindHighest() {

    Rider expected = riderService.shirtSortMountain(rider, shirtNotNull);

    assertEquals(rider, expected);
  }

  @Test
  public void shirtSortGreenWithNull() {
    Rider expected = riderService.shirtSortGreen(rider, shirt);

    assertEquals(rider, expected);
  }

  @Test
  public void shirtSortGreenHighestSprint() {
    Rider expected = riderService.shirtSortGreen(rider, shirtNotNull);

    assertEquals(rider, expected);
  }

  @Test
  public void shirtSortTimeWithNull() {
    Rider expected = riderService.shirtSortTime(rider, shirt);

    assertEquals(rider, expected);
  }

  @Test
  public void shirtSortTime() {
    Rider expected = riderService.shirtSortTime(rider, shirtNotNull);

    assertEquals(rider, expected);
  }

  //TODO Test calculateRiderAge and shirtSortWhite


/* @Test
  public void calculateRiderAge() {

    int expected = riderService.calculateRiderAge(rider);

    assertEquals(0, expected);
  }*/


}