package com.epam.springcource.service;

import com.epam.springcource.dao.AuditoriumDAO;
import com.epam.springcource.model.Auditorium;

import java.util.List;

/**
 * Created by romario
 */
public class AuditoriumService {
  private AuditoriumDAO auditoriumDao;

  public List<Auditorium> getAuditoriums() {
    return auditoriumDao.getAllAuditoriums();
  }

  public Auditorium getAuditorium(String name) {
    return auditoriumDao.getAuditorium(name);
  }

  public List<String> getVipSeats(String name) {
    Auditorium auditorium = auditoriumDao.getAuditorium(name);
    if (auditorium != null) {
      return auditorium.getVips();
    }
    return null;
  }

  public Integer getSeatsNumber(String name) {
    Auditorium auditorium = auditoriumDao.getAuditorium(name);
    if (auditorium != null) {
      return auditorium.getNumberOfSeats();
    }
    return null;
  }

  public void setAuditoriumDao(AuditoriumDAO auditoriumDao) {
    this.auditoriumDao = auditoriumDao;
  }
}
