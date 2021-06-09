package com.itacademy.startup.exceptions;


public class PlayerExistsException extends RuntimeException{

    public PlayerExistsException(String username) { super("username: " + username + " already exists");}
}

