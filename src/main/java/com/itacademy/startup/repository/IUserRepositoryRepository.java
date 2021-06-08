package com.itacademy.startup.repository;

import com.itacademy.startup.entity.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IUserRepositoryRepository extends MongoRepository<UserRepository, Integer> {

  List<UserRepository> findAll();
  UserRepository save(UserRepository userRepository);


}
