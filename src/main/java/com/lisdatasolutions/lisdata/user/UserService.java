package com.lisdatasolutions.lisdata.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User createUser(User user) {
    try {
      return userRepository.save(user);
    } catch (Exception e) {
      throw new UserServiceException("Error adding user", e);
    }
  }

  public List<User> getUsers() {
    try {
      List<User> users = userRepository.findAll();
      return users;
    } catch (Exception e) {
      throw new UserServiceException("Error getting the users", e);
    }
  }

  public User updateUser(int id, User updatedUser) {
    try {
      User user = userRepository.findById(id).orElse(null);
      if (user == null)
        throw new UserNotFoundException("User not found for update");
      user.setName(updatedUser.getName());
      user.setEmail(updatedUser.getEmail());
      user.setPhone(updatedUser.getPhone());
      user.setAge(updatedUser.getAge());
      user.setActive(updatedUser.isActive());

      return userRepository.save(user);
    } catch (Exception e) {
      throw new UserServiceException("Error updating the user");
    }
  }

  public boolean deleteUser(int id) {
    try {
      User user = userRepository.findById(id).orElse(null);
      if (user == null)
        throw new UserNotFoundException("Not found this user for delete");
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      throw new UserServiceException("Error deleting the user", e);
    }
  }

}
