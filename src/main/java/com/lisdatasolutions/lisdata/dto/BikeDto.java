package com.lisdatasolutions.lisdata.dto;

public class BikeDto {
  private String color;
  private boolean active;
  private boolean basket;
  private int typeId;

  public String getColor() {
    return color;
  }
  public void setColor(String color) {
    this.color = color;
  }
  public boolean isActive() {
    return active;
  }
  public void setActive(boolean active) {
    this.active = active;
  }
  public boolean isBasket() {
    return basket;
  }
  public void setBasket(boolean basket) {
    this.basket = basket;
  }
  public int getTypeId() {
    return typeId;
  }
  public void setTypeId(int typeId) {
    this.typeId = typeId;
  }
  
}
