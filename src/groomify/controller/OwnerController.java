/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.OwnerDAO;
import groomify.model.Owner;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class OwnerController {
    
    private OwnerDAO ownerDAO;
    
    public OwnerController(){
        ownerDAO = new OwnerDAO();
    }
    
    public boolean addOwner(Owner owner){
        return ownerDAO.addOwner(owner);
    }
    
    public boolean updateOwner(Owner owner){
        return ownerDAO.updateOwner(owner);
    }
    
    public boolean deleteOwner(int ownerId){
        return ownerDAO.deleteOwner(ownerId);
    }
    
    public Owner searchOwner(Object id){
        return ownerDAO.searchOwner(id);
    }
    
    public ArrayList<Owner> getAllOwners(){
        return ownerDAO.getAllOwners();
    }
    
    public ArrayList<String> getAllOwnerNames(){
        return ownerDAO.getAllOwnerNames();
    }
    
    public Owner searchByName(String name){
        return ownerDAO.searchByName(name);
    }
    
    public Owner getOwnerByOwnerId(int id){
        return ownerDAO.getOwnerByOwnerId(id);
    }
    
    public int getOwnerIdbyOwnerName(String name){
        return ownerDAO.getOwnerIdbyOwnerName(name);
    }
}
