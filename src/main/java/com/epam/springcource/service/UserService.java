package com.epam.springcource.service;

import com.epam.springcource.dao.UserDAO;
import com.epam.springcource.model.Ticket;
import com.epam.springcource.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by romario
 */
public class UserService {
  private UserDAO userDao;

  public boolean register(User user) {
    return userDao.saveUser(user);
  }

  public boolean remove(String id) {
    return userDao.removeUser(id);
  }

  public User getById(String id) {
    return userDao.getUser(id);
  }

  public User getByEmail(String email) {
    List<User> users = userDao.getAllUsers();
    for (User user : users) {
      if (StringUtils.isNotEmpty(user.getEmail()) && StringUtils
          .equalsIgnoreCase(email, user.getEmail())) {
        return user;
      }
    }
    return null;
  }

  public User getUsersByName(String name) {
    List<User> users = userDao.getAllUsers();
    for (User user : users) {
      if (StringUtils.isNotEmpty(user.getName()) && StringUtils
          .equalsIgnoreCase(name, user.getName())) {
        return user;
      }
    }
    return null;
  }

  public List<Ticket> getBookedTickets(String id) {
    User user = userDao.getUser(id);
    if (user != null) {
      return user.getBookedTickets();
    }
    return null;
  }

  public void setUserDao(UserDAO userDao) {
    this.userDao = userDao;
  }
}
