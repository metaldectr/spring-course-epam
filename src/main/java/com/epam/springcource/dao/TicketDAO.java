package com.epam.springcource.dao;

import com.epam.springcource.model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romario
 */
public class TicketDAO {
  private List<Ticket> tickets = new ArrayList<Ticket>();

  public List<Ticket> getAllTickets() {
    return tickets;
  }

  public boolean saveTicket(Ticket ticket) {
    if (ticket != null && !tickets.contains(ticket)) {
      tickets.add(ticket);
      return true;
    }
    return false;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}
