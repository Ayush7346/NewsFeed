package com.example.newsfeed.service;

import com.example.newsfeed.models.Comment;
import com.example.newsfeed.models.Reply;
import com.example.newsfeed.repo.CommentRepo;
import com.example.newsfeed.repo.NewsFeedRepo;
import com.example.newsfeed.repo.ReplyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    @Autowired
    NewsFeedRepo newsFeedRepo;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ReplyRepo replyRepo;


    @Autowired
    AccountManager accountManager;

    public void reply(long comment_id , String reply_text){

         Comment comment = commentRepo.findById(comment_id).get();

         Long user_id = accountManager.getCurrentUser().getUser_id();

        Reply reply = new Reply(user_id , reply_text,comment);

         comment.getReply().add(reply);

         replyRepo.save(reply);
    }
}
