package com.example.newsfeed.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long user_id;
    private String name;
    private String email;
    private String password;


    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "user_follow" , joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "follow_user_id"))
    private List<User> follow;


    public List<User> getFollow() {
        return follow;
    }

    public void setFollow(List<User> follow) {
        this.follow = follow;
    }

    public User(String name , String email , String password){
        this.name = name;
        this.email  = email;
        this.password  = password;
//        follow = new ArrayList<>();
    }

   public User(){

   }



    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
