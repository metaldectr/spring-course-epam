package com.epam.springcource.dao;

import com.epam.springcource.model.Auditorium;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by romario
 */
public class AuditoriumDAO {
  private Set<Auditorium> auditoriums = new HashSet<Auditorium>();

  public List<Auditorium> getAllAuditoriums() {
    return new ArrayList<Auditorium>(auditoriums);
  }

  public Auditorium getAuditorium(String name) {
    if (StringUtils.isNotEmpty(name)) {
      for (Auditorium auditorium : auditoriums) {
        if (StringUtils.equals(name, auditorium.getName())) {
          return auditorium;
        }
      }
    }
    return null;
  }

  public void setAuditoriums(Set<Auditorium> auditoriums) {
    this.auditoriums = auditoriums;
  }
}
