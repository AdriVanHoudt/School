package be.kdg.blogpost.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adri
 */
public interface Blog {

    public int addPost(User user, String url, String description);

    public boolean userExists(String username);

    public User getUser(String username);

    public Map getPosts();
}
