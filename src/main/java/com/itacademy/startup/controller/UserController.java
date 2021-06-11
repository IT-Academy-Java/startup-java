package com.itacademy.startup.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itacademy.startup.entity.User;
import com.itacademy.startup.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  @DeleteMapping("/users/{id}") //delete user
  public ResponseEntity<Object> deleteUserbyId(@PathVariable(name="id")String id) {
    try {
      userServiceImpl.deleteUserById(id);
      return ResponseEntity.ok().build();
    }catch(Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data not valid, wrong id");
    }

  }

}