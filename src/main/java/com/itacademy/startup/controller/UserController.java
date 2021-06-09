package com.itacademy.startup.controller;

import com.itacademy.startup.entity.User;
import com.itacademy.startup.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    //Show all the users
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userServiceImpl.listUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {

        return userServiceImpl.addUser(user);
    }

    }