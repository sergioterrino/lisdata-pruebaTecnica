package com.lisdatasolutions.lisdata.car;

public class CarNotFoundException extends RuntimeException{
  public CarNotFoundException(String msg){
      super(msg);
  }
}