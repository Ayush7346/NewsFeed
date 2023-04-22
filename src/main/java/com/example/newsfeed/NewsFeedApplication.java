package com.example.newsfeed;

import com.example.newsfeed.service.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsFeedApplication {
    @Autowired
    static  AccountManager accountManager;

    NewsFeedApplication(AccountManager accountManager){
        NewsFeedApplication.accountManager = accountManager;
    }
    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);


   //  boolean check  = accountManager.signUp("luv" , "luv@test.com" ,"luv123");


    boolean check = accountManager.login();
       System.out.print(check);

    }

}
