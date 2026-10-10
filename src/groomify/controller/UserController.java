/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.User;
import groomify.model.UserDAO;

/**
 *
 * @author Chirath
 */
public class UserController {
    private UserDAO userDAO;
    
    public UserController(){
        this.userDAO = new UserDAO();
    }
    
    public User checkCredentials(String username, String password){
        return userDAO.checkCredentials(username, password);
    }
}
