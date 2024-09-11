package com.lisdatasolutions.lisdata.bike;

public class BikeNotFoundException extends RuntimeException{
  public BikeNotFoundException(String msg){
      super(msg);
  }
}
