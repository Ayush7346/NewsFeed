package com.example.newsfeed.service;


import com.example.newsfeed.exception.UserNotFound;
import com.example.newsfeed.models.User;
import com.example.newsfeed.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AccountManager accountManager;

    public void followUser(String email) throws UserNotFound{

        User userFind = userRepo.findByEmail(email);

        if(userFind == null){
            throw new UserNotFound("USER NOT FOUND");
        }

        User curr_user = accountManager.getCurrentUser();
        curr_user.getFollow().add(userFind);
        userRepo.save(curr_user);
        curr_user.getFollow().clear();  // Clear the array so data repeat will happen (BUFFER)


    }

    public void unfollowUser(String email) throws UserNotFound{

        int chk = 0;

        User userFind = userRepo.findByEmail(email);

        if(userFind == null){
            throw new UserNotFound("USER NOT FOUND");
        }

        User curr_user = accountManager.getCurrentUser();

        for(int i = 0 ; i < curr_user.getFollow().size(); i++){

           if(curr_user.getFollow().get(i).getEmail().equals(email)){
               curr_user.getFollow().remove(i);
               chk  = 1;
           }
        }

        if(chk == 0){
            throw new UserNotFound("USER NOT FOUND IN CURRENT FOLLOW LIST");
        }

        userRepo.save(curr_user);


    }

}
