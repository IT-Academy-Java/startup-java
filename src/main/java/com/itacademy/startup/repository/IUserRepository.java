package com.itacademy.startup.repository;

import com.itacademy.startup.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IUserRepository extends MongoRepository<User, Long> {
    boolean existsByUsername(String username);

}
