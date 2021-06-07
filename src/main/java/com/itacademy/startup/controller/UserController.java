package com.itacademy.startup.controller;

import com.itacademy.startup.entity.User;
import com.itacademy.startup.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    }