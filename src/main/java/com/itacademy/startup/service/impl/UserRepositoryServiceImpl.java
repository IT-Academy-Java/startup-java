package com.itacademy.startup.service.impl;

import com.itacademy.startup.entity.UserRepository;
import com.itacademy.startup.repository.IUserRepositoryRepository;
import com.itacademy.startup.service.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryServiceImpl implements IUserRepositoryService {

  @Autowired
  private IUserRepositoryRepository userRepositoryRepository;

  @Override
  public List<UserRepository> getAllUserRepositories() {
    return userRepositoryRepository.findAll();
  }

  @Override
  public UserRepository saveUserRepository(UserRepository userRepository) {
    return userRepositoryRepository.save(userRepository);
  }

  @Override
  public Optional<UserRepository> getUserRepositoryById(String userRepositoryId) {
    return userRepositoryRepository.getUserRepositoryById(userRepositoryId);
  }

  @Override
  public Boolean deleteUserRepositoryById(String userRepositoryId) {
     //userRepositoryRepository.deleteById(userRepositoryId);
    return getUserRepositoryById(userRepositoryId).map(userRepository -> {
      userRepositoryRepository.deleteById(userRepositoryId);
      return true;
    }).orElse(false);
  }

}


