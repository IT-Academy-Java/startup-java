package com.itacademy.startup.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

    private String username;
    private String password;
    private String email;
    private int repos;

    // @OneToMany
    //private List<Repo> repos;

    public User() {
    }

    public User(String username, String password, String email, int repos) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.repos = repos;
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

    //@JsonIgnore
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "Game")

    /*
    public List<Repo> getRepos() {
        return repos;
    }

    public void setGames(List<Repo> repos) {
        this.repos = repos;
    }
     */
}




