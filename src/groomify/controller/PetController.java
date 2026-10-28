/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.CustomPetAndOwner;
import groomify.model.PetDAO;
import groomify.model.Pet;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class PetController {
    private PetDAO petDAO;
    
    public PetController(){
        petDAO = new PetDAO();
    }
    
    public boolean addPet(Pet pet){
        return petDAO.addPet(pet);
    }
    
    public boolean updatePet(Pet pet){
        return petDAO.updatePet(pet);
    }
    
    public boolean deletePet(int petId){
        return petDAO.deletePet(petId);
    }
    
    public Pet searchPet(Object id){
        return petDAO.searchPet(id);
    }
    
    public ArrayList<Pet> getAllPets(){
        return petDAO.getAllPets();
    }
    
    public ArrayList<Pet> getDogs(){
        return petDAO.getDogs();
    }
    
    public ArrayList<Pet> getCats(){
        return petDAO.getCats();
    }
    
    public ArrayList<Pet> getOtherPets(){
        return petDAO.getOtherPets();
    }
    
    public Pet searchPetByName(String name){
        return petDAO.searchPetByName(name);
    }
    
    public Pet getPetByPetAndOwnerNames(String petName, String ownerName){
        return petDAO.getPetByPetAndOwnerNames(petName, ownerName);
    }
    
    public ArrayList<CustomPetAndOwner> getAllPetAndOwnerNames(){
        return petDAO.getAllPetNamesAndOwnerNames();
    }
    
    public CustomPetAndOwner getPetAndOwnerNameByPetId(int petId){
        return petDAO.getPetAndOwnerNameByPetId(petId);
    }
    
    public int getPetCount(){
        return petDAO.getPetCount();
    }
}
