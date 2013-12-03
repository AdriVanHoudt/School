package be.kdg.blogpost.impl;

import be.kdg.blogpost.model.Blog;
import be.kdg.blogpost.model.Post;
import be.kdg.blogpost.model.User;
import org.springframework.stereotype.Service;
import javax.inject.Named;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Adri
 * Date: 28/11/13
 * Time: 14:18
 */
@Service("BlogService")
public class BlogImpl implements Blog {

    int unique_counter = 0;
    Map<Integer, Post> posts = new HashMap<>();
    Map<String, User> users = new HashMap<>();

    @Override
    public int addPost(User user, String url, String description) {
        unique_counter++;
        posts.put(unique_counter, new Post(unique_counter, user, url, description));
        return unique_counter;
    }

    @Override
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    @Override
    public User getUser(String username) {
        return this.users.get(username);
    }

    @Override
    public Map getPosts() {
        return this.posts;
    }
}
