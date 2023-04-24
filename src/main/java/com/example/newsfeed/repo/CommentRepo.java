package com.example.newsfeed.repo;

import com.example.newsfeed.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepo extends JpaRepository<Comment ,Long> {
}
