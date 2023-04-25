package com.example.newsfeed.service;

import com.example.newsfeed.models.User;
import com.example.newsfeed.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
public class AccountManager {

    private User curr_user;

    @Autowired
    UserRepo userRepository;


    public User getCurrentUser(){
        return this.curr_user;
    }

    public String hashPassword(String password){

        return password;
    }

    public boolean signUp(String name,String email , String password){

        if(userRepository.findByEmail(email) != null){
            return false;
        }
        else {
            User newUser = new User(name, email, hashPassword(password));
            userRepository.save(newUser);
            curr_user = newUser;
        }
        return  true;


    }

    public boolean login(String Enteremail , String password){



        User user = userRepository.findByEmail(Enteremail);


        if(user != null){   //Need to ipmplement



            if(hashPassword(password).equals(user.getPassword())){
                curr_user = user;
                return  true;
            }
        }
        return false;

    }
}
