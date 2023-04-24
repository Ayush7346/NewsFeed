package com.example.newsfeed.repo;

import com.example.newsfeed.models.FeedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsFeedRepo extends JpaRepository<FeedItem , Long> {
}
