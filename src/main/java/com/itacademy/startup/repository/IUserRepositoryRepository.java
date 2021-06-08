package com.itacademy.startup.repository;

import com.itacademy.startup.entity.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepositoryRepository extends MongoRepository<UserRepository, Integer> {

  List<UserRepository> findAll();
  Optional<UserRepository> getUserRepositoryById(String userRepositoryId);
  UserRepository save(UserRepository userRepository);
  //void delete(String userRepositoryId);
  void deleteById(String userRepositoryId);


}
