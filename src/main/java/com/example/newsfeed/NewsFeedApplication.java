package com.example.newsfeed;

import com.example.newsfeed.service.*;
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

    @Autowired
            static ReplyService replyService;

    NewsFeedApplication(AccountManager accountManager ,UserService userService ,NewsFeedService newsFeedService
    ,CommentService commentService , ReplyService replyService
    ){

        NewsFeedApplication.accountManager = accountManager;
        NewsFeedApplication.userService = userService;
        NewsFeedApplication.newsFeedService  = newsFeedService;
        NewsFeedApplication.commentService= commentService;
        NewsFeedApplication.replyService = replyService;
    }
    public static void main(String[] args) {
        SpringApplication.run(NewsFeedApplication.class, args);


        //  boolean check  = accountManager.signUp("luv" , "luv@test.com" ,"luv123");


        boolean check = accountManager.login();
        System.out.print(check);

//        newsFeedService.createPost("My First Post");
//    commentService.add_comment(1,"Ayush first comment");
try{
    replyService.reply(2,"first reply on comment id 2");

}
catch (Exception e){
    System.out.print(e);
}

    }
}
