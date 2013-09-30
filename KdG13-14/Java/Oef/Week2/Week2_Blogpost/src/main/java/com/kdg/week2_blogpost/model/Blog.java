package com.kdg.week2_blogpost.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adri
 */
public class Blog {

    private int unique_counter = 0;
    private List<Post> posts = new ArrayList<>();
    private List<User> users = new ArrayList<>();

   public synchronized void addPost(User user, String year, String specialization, String url, String description){
       unique_counter++;
       posts.add(new Post(unique_counter, user, year, specialization, url, description));
   }

    public boolean userExists(String username){
        return users.contains(new User(username));
    }

}
