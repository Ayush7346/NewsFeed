package com.example.newsfeed.repo;

import com.example.newsfeed.models.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepo extends JpaRepository<Reply,Long> {
}
