package com.itacademy.startup.exceptions;

public class EmailExistsException extends RuntimeException {
  public EmailExistsException(String email) {
    super("email: " + email + " already exists");
  }
}
