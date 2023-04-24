package com.example.newsfeed.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reply {

    @Id
    private Long reply_id;
    private String user_id;
    private String reply_text;

    @ManyToOne
    Comment comment;
}
