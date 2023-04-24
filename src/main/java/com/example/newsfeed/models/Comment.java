package com.example.newsfeed.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comment_id;
    private String comment_txt;
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "feeditem_id" )
     FeedItem  feedItem;


    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_txt() {
        return comment_txt;
    }

    public void setComment_txt(String comment_txt) {
        this.comment_txt = comment_txt;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public FeedItem getFeedItem() {
        return feedItem;
    }

    public void setFeedItem(FeedItem feedItem) {
        this.feedItem = feedItem;
    }

    public List<Reply> getReply() {
        return reply;
    }

    public void setReply(List<Reply> reply) {
        this.reply = reply;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public Comment(){

    }

    public Comment(String comment_txt , Long user_id , FeedItem feedItem){
         this.comment_txt = comment_txt;
         this.user_id = user_id;
         this.feedItem = feedItem;
    }

    @OneToMany(mappedBy = "reply_id")
    @Fetch(FetchMode.JOIN)
    private List<Reply> reply;
    private int upvote;
    private int downvote;



}
