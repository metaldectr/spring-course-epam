package com.epam.springcource.dao;

import com.epam.springcource.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by romario
 */
public class UserDAO {

  private Map<String, User> users = new HashMap<String, User>();

  public boolean saveUser(User user) {
    if (user != null && !StringUtils.isEmpty(user.getId()) && !users.containsKey(user.getId())) {
      users.put(user.getId(), user);
      return true;
    }
    return false;
  }

  public boolean removeUser(String userId) {
    if (StringUtils.isEmpty(userId) || !users.containsKey(userId)) {
      return false;
    }
    users.remove(userId);
    return true;
  }

  public boolean removeUser(User user) {
    if (user != null) {
      return removeUser(user.getId());
    }
    return false;
  }

  public User getUser(String userID) {
    if (StringUtils.isNotEmpty(userID)) {
      return users.get(userID);
    }
    return null;
  }

  public List<User> getAllUsers() {
    return new ArrayList<User>(users.values());
  }

  public void setUsers(Map<String, User> users) {
    this.users = users;
  }
}
