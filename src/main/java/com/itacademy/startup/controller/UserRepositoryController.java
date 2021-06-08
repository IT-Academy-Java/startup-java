package com.itacademy.startup.controller;

import com.itacademy.startup.entity.UserRepository;
import com.itacademy.startup.service.impl.UserRepositoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
