package com.epam.springcource.service;

import com.epam.springcource.dao.EventDAO;
import com.epam.springcource.dao.EventInformationDAO;
import com.epam.springcource.model.Auditorium;
import com.epam.springcource.model.Event;
import com.epam.springcource.model.EventInformation;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by romario
 */
public class EventService {
  private EventInformationDAO eventInformationDAO;
  private EventDAO eventDao;

  public boolean createEventInformation(EventInformation event) {
    return eventInformationDAO.saveEvent(event);
  }

  public boolean removeEventInformation(String name) {
    List<Event> events = eventDao.getEvents();
    for (Event event : events) {
      if (event.getBaseInfo().getName().equals(name)) {
        removeEvent(event);
      }
    }
    return eventInformationDAO.removeEvent(name);
  }

  public boolean removeEvent(Event event) {
    return eventDao.removeEvent(event);
  }

  public boolean removeEventInformation(EventInformation event) {
    if (event != null) {
      return eventInformationDAO.removeEvent(event.getName());
    }
    return false;
  }

  public EventInformation getEventInformationByName(String name) {
    return eventInformationDao.getEvent(name);
  }

  public List<EventInformation> getAllEventInformation() {
    return eventInformationDAO.getAllEvents();
  }

  public List<Event> getForDateRange(Date from, Date to) {
    List<Event> filteredEvents = new ArrayList<Event>();
    if (from != null && to != null) {
      List<Event> events = eventDao.getEvents();
      for (Event event : events) {
        Date eventStart = event.getTime();
        if ((from.before(eventStart) && to.after(eventStart)) || from.equals(eventStart) || to
            .equals(eventStart)) {
          filteredEvents.add(event);
        }
      }
    }
    return filteredEvents;
  }

  public List<Event> getNextEvents(Date to) {
    return getForDateRange(new Date(), to);
  }

  public Event assignAuditorium(EventInformation EventInformation, Auditorium auditorium,
      Date date) {
    List<Event> events = eventDao.getEvents();
    Date filmFinish = DateUtils.addHours(date, EventInformation.getDuration());
    for (Event event : events) {
      if (event.getAuditorium() == auditorium) {
        Date eventFinish = DateUtils.addHours(event.getTime(), event.getBaseInfo().getDuration());
        if ((date.before(event.getTime()) && filmFinish.after(eventFinish)) ||
            (date.after(event.getTime()) && filmFinish.before(eventFinish)) ||
            (filmFinish.before(eventFinish) && filmFinish.after(event.getTime())) ||
            (date.after(event.getTime()) && date.before(eventFinish)) ||
            date.equals(event.getTime()) || date.equals(eventFinish) ||
            filmFinish.equals(event.getTime()) || filmFinish.equals(eventFinish)) {
          return null;
        }
      }
    }
    Event event = new Event(EventInformation, date, auditorium);
    eventDao.saveEvent(event);
    return event;
  }

  public void setEventDao(EventDAO eventDao) {
    this.eventDao = eventDao;
  }

  public void setEventInformationDAO(EventInformationDAO eventInformationDAO) {
    this.eventInformationDAO = eventInformationDAO;
  }
}
