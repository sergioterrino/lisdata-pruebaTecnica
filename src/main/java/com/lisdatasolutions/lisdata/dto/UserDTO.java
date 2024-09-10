package com.lisdatasolutions.lisdata.dto;

public class UserDTO {
  private char name, email, phone;
  private int age;
  private boolean active;

  public char getName() {
    return name;
  }
  public void setName(char name) {
    this.name = name;
  }
  public char getEmail() {
    return email;
  }
  public void setEmail(char email) {
    this.email = email;
  }
  public char getPhone() {
    return phone;
  }
  public void setPhone(char phone) {
    this.phone = phone;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public boolean isActive() {
    return active;
  }
  public void setActive(boolean active) {
    this.active = active;
  }

}
