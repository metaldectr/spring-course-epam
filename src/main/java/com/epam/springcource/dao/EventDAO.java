package com.epam.springcource.dao;

import com.epam.springcource.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romario
 */
public class EventDAO {
  private List<Event> events = new ArrayList<Event>();

  public boolean saveEvent(Event event){
    if(!events.contains(event)){
      events.add(event);
    }
    return false;
  }

  public boolean removeEvent(Event event){
    if (events.contains(event)){
      events.remove(event);
      return true;
    }
    return false;
  }

  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }
}
