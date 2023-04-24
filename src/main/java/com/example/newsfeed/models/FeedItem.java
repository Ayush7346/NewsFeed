package com.example.newsfeed.models;


import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


@Entity
public class FeedItem {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long feeditem_id;
    private Long userId;
    private String content;
    private String time;

    @OneToMany(mappedBy = "feedItem" )
    @Fetch(FetchMode.JOIN)
    private List<Comment> comments;


    private int upvote;
    private int downvote;

    public int getUpvote() {
        return upvote;
    }


    public int getDownvote() {
        return downvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public FeedItem(Long user_id, String content, String time) {
        this.userId = user_id;
        this.content = content;
        this.time = time;

        upvote = 0;
        downvote = 0;
        comments  = new ArrayList<>();

    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public FeedItem() {

    }

    public Long getFeeditem_id() {
        return feeditem_id;
    }

    public void setFeeditem_id(Long feeditem_id) {
        this.feeditem_id = feeditem_id;
    }

    public Long getUser_id() {
        return userId;
    }

    public void setUser_id(Long user_id) {
        this.userId = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
