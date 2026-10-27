/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.UpNextDAO;
import java.util.ArrayList;
import groomify.model.UpNext;

/**
 *
 * @author Chirath
 */
public class UpNextController {
    private UpNextDAO upNextDAO;
    
    public UpNextController(){
        upNextDAO = new UpNextDAO();
    }
    
    public ArrayList<UpNext> getUpNexts(){
        return upNextDAO.getUpNext();
    }
}
