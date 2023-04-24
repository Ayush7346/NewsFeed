package com.example.newsfeed;

import com.example.newsfeed.service.AccountManager;
import com.example.newsfeed.service.CommentService;
import com.example.newsfeed.service.NewsFeedService;
import com.example.newsfeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsFeedApplication {
    @Autowired
    static  AccountManager accountManager;
    @Autowired
    static UserService userService;

    @Autowired
    static NewsFeedService newsFeedService;

    @Autowired
    static CommentService commentService;

    NewsFeedApplication(AccountManager accountManager ,UserService userService ,NewsFeedService newsFeedService
    ,CommentService commentService
    ){

        NewsFeedApplication.accountManager = accountManager;
        NewsFeedApplication.userService = userService;
        NewsFeedApplication.newsFeedService  = newsFeedService;
        NewsFeedApplication.commentService= commentService;
    }
    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);


        //  boolean check  = accountManager.signUp("luv" , "luv@test.com" ,"luv123");


        boolean check = accountManager.login();
        System.out.print(check);

//        newsFeedService.createPost("My First Post");
        commentService.add_comment(1,"Ayush first comment");

    }
}
