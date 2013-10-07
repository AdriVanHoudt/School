package com.kdg.week2_blogpost.model;

/**
 *
 * @author Adri
 */
public class Post {

    private String description;
    private int id;
    private String year;
    private User user;
    private String specialization;
    private String url;
    private Blog blog;

    public Post(int id, User user, String year, String specialization, String url, String description) {
        this.id = id;
        this.year = year;
        this.specialization = specialization;
        this.url = url;
        this.description = description;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public User getUser() {
        return user;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getUrl() {
        return url;
    }

    public Blog getBlog() {
        return blog;
    }

    
}
