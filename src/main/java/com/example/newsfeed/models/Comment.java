package com.example.newsfeed.models;

import java.util.List;

public class Comment {

    private String comment_id;
    private String comment_txt;
    private String user_id;
    private String feed_id;
    private List<Reply> reply;
    private int upvote;
    private int downvote;

    public void upvote(){

    }

    public void downvote(){

    }

    public void reply(){

    }

}
