package com.epam.springcource.model;

import java.util.List;

/**
 * Created by romario
 */
public class Auditorium {
  private String name;
  private Integer numberOfSeats;
  private List<String> vips;

  public List<String> getVips() {
    return vips;
  }

  public void setVips(List<String> vips) {
    this.vips = vips;
  }

  public Integer getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
