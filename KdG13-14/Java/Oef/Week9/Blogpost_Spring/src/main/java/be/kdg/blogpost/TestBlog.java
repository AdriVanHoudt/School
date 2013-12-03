package be.kdg.blogpost;

import be.kdg.blogpost.model.Blog;
import be.kdg.blogpost.model.Post;
import be.kdg.blogpost.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Adri
 * Date: 28/11/13
 * Time: 14:32
 */
public class TestBlog {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        Blog blog  = (Blog) context.getBean("BlogService");

        blog.addPost(new User("adri", "pom", "1993"), "www.google.com", "lalalalalasfdogorejgoijovjsdouibijmsfdjùvoijdmoivpumo!ser" );
        System.out.println(blog.getPosts().get(1));
    }
}
