package com.kdg.week2_blogpost.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Adri
 */
public class Blog {

    private int unique_counter = 0;
    private Map<Integer, Post> posts;
    private Map<String, User> users;

    public Blog() {
        this.posts = new HashMap<>();
        this.users = new HashMap<>();
    }

    public synchronized int addPost(User user, String url, String description) {
        unique_counter++;
        posts.put(unique_counter, new Post(unique_counter, user, url, description));
        return unique_counter;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public Map getPosts() {
        return this.posts;
    }
}
