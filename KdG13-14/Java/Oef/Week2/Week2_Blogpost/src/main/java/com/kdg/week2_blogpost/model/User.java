package com.kdg.week2_blogpost.model;

/**
 * User: Adri
 * Date: 30/09/13
 * Time: 14:13
 */
public class User {

    private String username;
    private String specialization;
    private String year;
    
    public User(String username, String specialization, String year) {
        this.username = username;
        this.specialization = specialization;
        this.year = year;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
