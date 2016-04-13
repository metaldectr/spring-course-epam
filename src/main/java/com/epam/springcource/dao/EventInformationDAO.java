package com.epam.springcource.dao;

import com.epam.springcource.model.EventInformation;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by romario
 */
public class EventInformationDAO {

  private Map<String, EventInformation> events = new HashMap<String, EventInformation>();

  public boolean saveEvent(EventInformation event) {
    if (event != null && StringUtils.isNotEmpty(event.getName()) && !events.containsKey(event.getName())) {
      events.put(event.getName(), event);
      return true;
    }
    return false;
  }

  public EventInformation getEvent(String name) {
    if (StringUtils.isNotEmpty(name)) {
      return events.get(name);
    }
    return null;
  }

  public boolean updateEvent(EventInformation event) {
    throw new UnsupportedOperationException("Update operation will be supported soon. When DB will be added");
  }

  public boolean removeEvent(String name) {
    if (StringUtils.isNotEmpty(name)) {
      events.remove(name);
      return true;
    }
    return false;
  }

  public List<EventInformation> getAllEvents() {
    return new ArrayList<EventInformation>(events.values());
  }

  public void setEvents(Map<String, EventInformation> events) {
    this.events = events;
  }
}
