package com.epam.springcource.model;

import java.util.Date;

/**
 * Created by romario
 */
public class Event {
  private EventInformation baseInfo;
  private Date time;
  private Auditorium auditorium;
  private double vipSeatAdditionalFee;

  public Event() {
  }

  public Event(EventInformation baseInfo, Date time, Auditorium auditorium) {
    this.baseInfo = baseInfo;
    this.time = time;
    this.auditorium = auditorium;
    vipSeatAdditionalFee = (auditorium.getNumberOfSeats() / auditorium.getVips().size());
  }

  public EventInformation getBaseInfo() {
    return baseInfo;
  }

  public void setBaseInfo(EventInformation baseInfo) {
    this.baseInfo = baseInfo;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Auditorium getAuditorium() {
    return auditorium;
  }

  public void setAuditorium(Auditorium auditorium) {
    this.auditorium = auditorium;
    vipSeatAdditionalFee = (auditorium.getNumberOfSeats() / auditorium.getVips().size());
  }

  public double getVipSeatAdditionalFee() {
    return vipSeatAdditionalFee;
  }

  public void setVipSeatAdditionalFee(double vipSeatAdditionalFee) {
    this.vipSeatAdditionalFee = vipSeatAdditionalFee;
  }
}
