/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.kdg.repaircafemodel.persistence.api;

import be.kdg.repaircafemodel.dom.users.User;
import be.kdg.repaircafemodel.service.exceptions.UserServiceException;
import java.util.Map;

/**
 *
 * @author wouter
 */
public interface UserDAO
{
    public User getUser(String username);
    public void addUser(User user) throws UserServiceException;
    public void removeUser(String username);    
    public Map<String, User> getUsers();    
}
