package com.itacademy.startup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itacademy.startup.entity.User;
import com.itacademy.startup.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserServiceImpl userServiceImpl;

  @GetMapping()
  public List<User> getAllUsers() {
    return userServiceImpl.listUsers();
  }

  @GetMapping(("/{username}"))
  public User getGithubUserByUsername(@PathVariable("username") String username) throws JsonProcessingException {
    return userServiceImpl.getUserFromGithubAPI(username);
  }

  @PostMapping()
  public User addUser(@RequestBody User user) {
    return userServiceImpl.addUser(user);
  }

}