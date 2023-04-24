package com.example.newsfeed.service;

import com.example.newsfeed.models.Comment;
import com.example.newsfeed.models.FeedItem;
import com.example.newsfeed.repo.CommentRepo;
import com.example.newsfeed.repo.NewsFeedRepo;
import com.example.newsfeed.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    NewsFeedRepo newsFeedRepo;
    @Autowired
    AccountManager accountManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CommentRepo commentRepo;


    public void add_comment(long feed_id , String comment_txt){

        FeedItem feedItem = newsFeedRepo.findById(feed_id).get();


        Comment comment = new Comment(comment_txt , accountManager.getCurrentUser().getUser_id() );

        feedItem.getComments().add(comment);
        commentRepo.save(comment);

    }
}
