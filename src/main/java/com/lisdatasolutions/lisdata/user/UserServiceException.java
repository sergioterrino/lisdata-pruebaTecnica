package com.lisdatasolutions.lisdata.user;

public class UserServiceException extends RuntimeException{
  public UserServiceException(String msg){
    super(msg);
  }

  public UserServiceException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
