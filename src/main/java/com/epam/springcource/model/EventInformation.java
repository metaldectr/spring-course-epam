package com.epam.springcource.model;

/**
 * Created by romario
 */
public class EventInformation {
  private String name;
  private Double basePrice;
  private Integer duration;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    EventInformation event = (EventInformation) o;
    return name.equals(event.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
