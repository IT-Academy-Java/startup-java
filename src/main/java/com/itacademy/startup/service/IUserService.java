package com.itacademy.startup.service;

import com.itacademy.startup.entity.User;
import java.util.List;

public interface IUserService {

	//Metodos del CRUD
	List<User> listUsers(); //list all

	User addUser(User user);
}
