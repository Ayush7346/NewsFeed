package com.example.newsfeed.models;


import jakarta.persistence.*;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reply_id;
    private Long user_id;
    private String reply_text;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    Comment comment;

    public Long getReply_id() {
        return reply_id;
    }

    public void setReply_id(Long reply_id) {
        this.reply_id = reply_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getReply_text() {
        return reply_text;
    }

    public void setReply_text(String reply_text) {
        this.reply_text = reply_text;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Reply(Long user_id, String reply_text , Comment comment){

        this.user_id = user_id;
        this.reply_text = reply_text;
        this.comment = comment;

    }
    public Reply(){

    }
}
