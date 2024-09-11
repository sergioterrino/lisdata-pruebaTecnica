package com.lisdatasolutions.lisdata.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.lisdatasolutions.lisdata.dto.UserWithInactiveVehicles;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping("/create")
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User newUser = userService.createUser(user);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
    User user = userService.updateUser(id, updatedUser);
    return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable int id){
    boolean isDeleted = userService.deleteUser(id);
    return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND); 
  }

  @GetMapping("/active")
  public ResponseEntity<List<User>> getActiveUsers() {
    List<User> activeUsers = userService.getActiveUsers();
    return ResponseEntity.ok(activeUsers);
  }

  @GetMapping("/active-with-inactive-vehicles")
    public ResponseEntity<List<UserWithInactiveVehicles>> getActiveUsersWithInactiveVehicles() {
    List<UserWithInactiveVehicles> usersWithInactiveVehicles = userService.getActiveUsersWithInactiveVehicles();
    return ResponseEntity.ok(usersWithInactiveVehicles);
  }

}