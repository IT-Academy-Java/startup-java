package com.itacademy.startup.exceptions;

public class UserExistsException extends RuntimeException {
  public UserExistsException(String username) {
    super("username: " + username + " already exists");
  }
}
