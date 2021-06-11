package com.itacademy.startup.service.impl;

import com.itacademy.startup.entity.User;
import com.itacademy.startup.exceptions.EmailExistsException;
import com.itacademy.startup.exceptions.PlayerNotFoundException;
import com.itacademy.startup.exceptions.UserExistsException;
import com.itacademy.startup.repository.IUserRepository;
import com.itacademy.startup.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  IUserRepository iUserRepository;

  @Autowired
  RestTemplate restTemplate;

  @Override
  public List<User> listUsers() {
    return iUserRepository.findAll();
  }

  @Override
  public User addUser(User user) {
    if (iUserRepository.existsByUsername(user.getUsername())) {
      throw new UserExistsException(user.getUsername());
    } else if (iUserRepository.existsByEmail(user.getEmail())) {
      throw new EmailExistsException(user.getEmail());
    } else {
      return iUserRepository.save(user);
    }
  }

  @Override
  public User getUserFromGithubAPI(String username) {
    User user = new User();
    String githubApiUrl = "https://api.github.com/users/" + username;
    ResponseEntity<String> response = restTemplate.getForEntity(githubApiUrl, String.class);

    String repo = response.getBody();
    repo = repo.replace("{", "");
    repo = repo.replace("}", "");

    Map<String, String> map = Arrays.stream(repo.split(","))
      .map(s -> s.split(":"))
      .collect(Collectors.toMap(s -> s[0].replace("\"", ""), s -> s[1].replace("\"", "")));

    System.out.println(Collections.singletonList(map.get("login")));

    if (response.getStatusCode() == HttpStatus.OK) {
      user.setId(map.get("id"));
      user.setUsername(map.get("login"));
      user.setEmail(map.get("email"));
      user.setRepos(Integer.parseInt(map.get("public_repos")));
    }
    return user;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public void deleteUserById(String id) {
    User myUser = iUserRepository.findById(id);
    if(myUser == null) {
      throw new PlayerNotFoundException(id);
    }
    iUserRepository.deleteById(id);
  }
}
