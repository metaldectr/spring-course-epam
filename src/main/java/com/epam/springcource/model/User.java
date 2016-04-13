package com.epam.springcource.model;

import java.util.Date;
import java.util.List;

/**
 * Created by romario
 */
public class User {
  private String id;
  private String email;
  private String name;
  private List<Ticket> bookedTickets;
  private Date birthday;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Ticket> getBookedTickets() {
    return bookedTickets;
  }

  public void setBookedTickets(List<Ticket> bookedTickets) {
    this.bookedTickets = bookedTickets;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    if (!email.equals(user.email))
      return false;
    if (!name.equals(user.name))
      return false;
    return birthday.equals(user.birthday);

  }

  @Override
  public int hashCode() {
    int result = email.hashCode();
    result = 51 * result + name.hashCode();
    result = 51 * result + birthday.hashCode();
    return result;
  }
}
