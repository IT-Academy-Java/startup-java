package com.itacademy.startup.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "repository")
public class UserRepository {

  private String name;
  private String url;
  private String description;
  private String[] stack;

  public UserRepository() {
  }

  public UserRepository(String name, String url, String description, String[] stack) {
    this.name = name;
    this.url = url;
    this.description = description;
    this.stack = stack;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String[] getStack() {
    return stack;
  }

  public void setStack(String[] stack) {
    this.stack = stack;
  }
}
