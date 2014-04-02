/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.service.api;

import be.kdg.repaircafemodel.dom.users.Person;
import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;

/**
 *
 * @author wouter
 */
public interface UserService
{
    public void checkLogin(String username, String password) throws UserServiceException;
    public User getUser(String username) throws UserServiceException;    
    
    public void updateUser(User user, Person person);
    public void updatePassword(User user, String oldPassword, String newPassword) throws UserServiceException;
            
    public void addUser(User user) throws UserServiceException;
    public void removeUser(String username);    

    public void removeAllUsers();
    
}
