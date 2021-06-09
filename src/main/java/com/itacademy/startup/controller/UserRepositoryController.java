package com.itacademy.startup.controller;

import com.itacademy.startup.entity.UserRepository;
import com.itacademy.startup.service.impl.UserRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repositories")
public class UserRepositoryController {

  @Autowired
  private UserRepositoryServiceImpl service;

  @GetMapping()
  @ResponseBody
  public List<UserRepository> getUserRepositories() throws Exception{
    return service.getAllUserRepositories();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<UserRepository> getUserRepositoriesById(@PathVariable("id") String userRepositoryId) throws Exception{
    return service.getUserRepositoryById(userRepositoryId)
      .map(userRepository -> new ResponseEntity<>(userRepository, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping()
  public ResponseEntity<UserRepository> save(@RequestBody UserRepository userRepository) {
    return new ResponseEntity<>(service.saveUserRepository(userRepository), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") String userRepositoryId) {
    service.deleteUserRepositoryById(userRepositoryId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
