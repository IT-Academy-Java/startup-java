package com.itacademy.startup.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
public class User {

  @Id
  private String id;

  private String username;
  private String password;
  private String email;
  private int repos;

  @DBRef(db = "user")
  private List<UserRepository> userRepositoryList;

  public User() {
  }

  public User(String id, String username, String password, String email, int repos) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.repos = repos;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<UserRepository> getUserRepositoryList() {
    return userRepositoryList;
  }

  public void setUserRepositoryList(List<UserRepository> userRepositoryList) {
    this.userRepositoryList = userRepositoryList;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getRepos() {
    return repos;
  }

  public void setRepos(int repos) {
    this.repos = repos;
  }

}




