package com.example.newsfeed.service;

import com.example.newsfeed.models.FeedItem;
import com.example.newsfeed.models.Newsfeed;
import com.example.newsfeed.models.User;
import com.example.newsfeed.repo.NewsFeedRepo;
import com.example.newsfeed.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class NewsFeedService {

    @Autowired
    NewsFeedRepo newsFeedRepo;
    @Autowired
    AccountManager accountManager;
    @Autowired
    UserRepo userRepo;

    public void createPost(String content){

        User curr_user = accountManager.getCurrentUser();
        FeedItem newFeed  = new FeedItem(curr_user.getUser_id() , content , LocalDateTime.now().toString());

        newsFeedRepo.save(newFeed);
    }

    public void upvote(Long feed_id){

          FeedItem feedItem = newsFeedRepo.findById(feed_id).get();
         int upvote_value =  feedItem.getUpvote()+1;
         feedItem.setUpvote(upvote_value);
         newsFeedRepo.save(feedItem);

    }

    public void downVote(Long feed_id){

        FeedItem feedItem = newsFeedRepo.findById(feed_id).get();
        int downvote_value =  feedItem.getDownvote()+1;
        feedItem.setDownvote(downvote_value);
        newsFeedRepo.save(feedItem);

    }


    public List<FeedItem> getNewsFeed(){


        Long userId = accountManager.getCurrentUser().getUser_id();
        List<User>  follow_list = userRepo.findById(userId).get().getFollow();

        List<FeedItem> newsFeedList = new ArrayList<>((Collection) new SortService());


        for(int i = 0; i < follow_list.size(); i++){

            Long userFind = follow_list.get(i).getUser_id();

            List<FeedItem> feeds = newsFeedRepo.findByUserId(userFind);

                for(int j= 0 ; j < feeds.size();  j++){
                    newsFeedList.add(feeds.get(j));
                }
        }


        return newsFeedList;

    }



}
