/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafemodel.service.impl;

import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import be.kdg.repaircafemodel.persistence.api.UserDAO;
import be.kdg.repaircafemodel.service.api.UserService;
import java.util.ConcurrentModificationException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Users are stored in map with ther unique usernames being keys.
 * A user can be Client or a Repairer.
 * @author wouter
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO userDAO;

    /**
     * Hier wordt gecontroleerd of de user bestaat en of zijn password correct
     * is. Indien één van deze controles faalt, wordt een UserServiceException gegooid.
     *
     * @param username gebruikersnaam
     * @param password wachtwoord
     * @throws UserServiceException indien foute credentials gegeven zijn
     */
    @Override
    public void checkLogin(String username, String password) throws UserServiceException
    {
        // haal deze gebruiker op
        User user;
        try
        {
            user = userDAO.getUser(username);
            // mogelijk is user null -> NullPointerException 
            if (!user.checkPassword(password.toCharArray()))
            {
                throw new UserServiceException(("Gebruikersnaam of password foutief"));
            }
        }
        catch (Exception ex)
        {
            throw new UserServiceException(("Gebruikersnaam of password foutief"));
        }

    }

    /**
     * Voeg een gebruiker toe aan het systeem.
     *
     * @param user
     * @throws be.kdg.repaircafemodel.service.exceptions.UserServiceException
     */
    @Override
    public void addUser(User user) throws UserServiceException
    {
        userDAO.addUser(user);
    }

    /**
     * Removes user having this username
     *
     * @param username
     */
    @Override
    public void removeUser(String username)
    {
        userDAO.removeUser(username);
    }

    /**
     * Returns user having username
     *
     * @param username
     * @return
     * @throws be.kdg.repaircafemodel.service.exceptions.UserServiceException
     */
    @Override
    public User getUser(String username) throws UserServiceException
    {
        try
        {
            return userDAO.getUser(username);
        }
        catch (ConcurrentModificationException ex)
        {
            throw new UserServiceException(ex.getMessage());
        }
    }

    /**
     * Update an existing user with new Person details
     * @param user
     * @param person
     */
    @Override
    public void updateUser(User user, Person person)
    {
        user.setPerson(person);        
    }

    /**
     * Update password for an existing user
     * @param user
     * @param oldPassword
     * @param newPassword
     * @throws UserServiceException
     */
    @Override
    public void updatePassword(User user, String oldPassword, String newPassword) throws UserServiceException
    {
        user.changePassword(oldPassword,newPassword);
    }

    /**
     * Clear all users.
     */
    @Override
    public void removeAllUsers()
    {
        final Map<String, User> users = userDAO.getUsers();
        users.clear();
    }

}