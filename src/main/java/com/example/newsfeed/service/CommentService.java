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


        Comment comment = new Comment(comment_txt , accountManager.getCurrentUser().getUser_id() , feedItem );

        feedItem.getComments().add(comment);

        System.out.print(feedItem.getComments().get(0).getComment_txt());
        commentRepo.save(comment);

    }

    public void upvote(Long comment_id){

        Comment comment = commentRepo.findById(comment_id).get();
        int upvote_value =  comment.getUpvote()+1;
        comment.setUpvote(upvote_value);
        commentRepo.save(comment);

    }

    public void downVote(Long comment_id){

        Comment comment = commentRepo.findById(comment_id).get();
        int downvote_value =  comment.getDownvote()+1;
        comment.setDownvote(downvote_value);
        commentRepo.save(comment);

    }
}
