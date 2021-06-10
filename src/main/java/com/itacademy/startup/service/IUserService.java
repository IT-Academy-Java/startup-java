package com.itacademy.startup.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itacademy.startup.entity.User;
import java.util.List;

public interface IUserService {

	List<User> listUsers();
	User addUser(User user);
	User getUserFromGithubAPI(String username) throws JsonProcessingException;

}
