package com.epam.springcource.service;

import com.epam.springcource.dao.TicketDAO;
import com.epam.springcource.model.Event;
import com.epam.springcource.model.Ticket;
import com.epam.springcource.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romario
 */
public class BookingService {
  private TicketDAO ticketDao;
  private DiscountService discountService;

  public List<Ticket> getTicketPrice(Event event, List<String> seats, User user) {
    List<Ticket> tickets = new ArrayList<Ticket>();
    if (event != null && seats != null && seats.size() > 0) {
      List<Ticket> bookedTickets = getTicketsForEvent(event);
      for (Ticket ticket : bookedTickets) {
        if (seats.contains(String.valueOf(ticket.getSeatNumber()))) {
          seats.remove(String.valueOf(ticket.getSeatNumber()));
        }
      }
      for (String seatNumber : seats) {
        Ticket ticket = new Ticket();
        ticket.setEvent(event);
        ticket.setSeatNumber(Integer.valueOf(seatNumber));
        boolean isVIP = event.getAuditorium().getVips().contains(seatNumber);
        ticket.setPrice(event.getBaseInfo().getBasePrice());
        if (isVIP) {
          ticket.setPrice(ticket.getPrice() * event.getVipSeatAdditionalFee());
        }
        if (user != null) {
          double discount = discountService.getDiscount(user, event);
          ticket.setPrice(ticket.getPrice() * discount);
        }
        tickets.add(ticket);
      }
    }
    return tickets;
  }

  public boolean bookTicket(User user, Ticket ticket) {
    if (ticket != null && ticket.getEvent() != null && ticket.getSeatNumber() != null) {
      List<Ticket> bookedTickets = ticketDao.getAllTickets();
      for (Ticket bookedTicket : bookedTickets) {
        if (bookedTicket.equals(ticket)) {
          return false;
        }
      }
      if (ticketDao.saveTicket(ticket)) {
        if (user != null) {
          user.getBookedTickets().add(ticket);
        }
        return true;
      }
    }
    return false;
  }

  public List<Ticket> getTicketsForEvent(Event event) {
    List<Ticket> filteredTickets = new ArrayList<Ticket>();
    List<Ticket> bookedTickets = ticketDao.getAllTickets();
    for (Ticket ticket : bookedTickets) {
      if (ticket.getEvent().equals(event)) {
        filteredTickets.add(ticket);
      }
    }
    return filteredTickets;
  }

  public void setTicketDao(TicketDAO ticketDao) {
    this.ticketDao = ticketDao;
  }

  public void setDiscountService(DiscountService discountService) {
    this.discountService = discountService;
  }
}
