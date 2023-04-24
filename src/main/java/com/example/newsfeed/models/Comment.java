package com.example.newsfeed.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;
    private String comment_txt;
    private Long user_id;

    @ManyToOne
     FeedItem  feedItem;



    Comment(){

    }

    public Comment(String comment_txt , Long user_id){
         this.comment_txt = comment_txt;
         this.user_id = user_id;
    }

    @OneToMany(mappedBy = "reply_id")
    private List<Reply> reply;
    private int upvote;
    private int downvote;



}
