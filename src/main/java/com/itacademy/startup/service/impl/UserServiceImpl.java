package com.itacademy.startup.service.impl;

import com.itacademy.startup.entity.User;
import com.itacademy.startup.exceptions.PlayerExistsException;
import com.itacademy.startup.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements com.itacademy.startup.service.IUserService {

	@Autowired
	IUserRepository iUserRepository;


	@Override
	public List<User> listUsers() {
		return iUserRepository.findAll();
	}

	@Override
	public User addUser(User user) {

		if (iUserRepository.existsByName(user.getUsername())) {
			throw new PlayerExistsException(user.getUsername());
		} else {
			return iUserRepository.save(user);
		}
	}
}
