package com.itacademy.startup.service;

import com.itacademy.startup.entity.UserRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepositoryService {

  public List<UserRepository> getAllUserRepositories();
  public UserRepository saveUserRepository(UserRepository userRepository);
  public Optional<UserRepository> getUserRepositoryById(String userRepositoryId);
  //public void deleteUserRepositoryById(String userRepositoryId);
  public Boolean deleteUserRepositoryById(String userRepositoryId);
}
