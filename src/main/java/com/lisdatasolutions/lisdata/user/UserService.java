package com.lisdatasolutions.lisdata.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisdatasolutions.lisdata.dto.UserWithInactiveVehicles;
import com.lisdatasolutions.lisdata.vehicle.VehicleRepository;


@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private VehicleRepository vehicleRepository;

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

  public List<User> getActiveUsers() {
    try {
      return userRepository.findByActiveTrue();
    } catch (Exception e) {
      throw new UserServiceException("Error getting the active users", e);
    }
  }

  public List<UserWithInactiveVehicles> getActiveUsersWithInactiveVehicles() {
    List<User> activeUsers = userRepository.findByActiveTrue();
    return activeUsers.stream()
            .map(user -> new UserWithInactiveVehicles(user, vehicleRepository.findByUserIdAndActiveFalse(user.getId())))
            .collect(Collectors.toList());
  }

}