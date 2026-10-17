/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

/**
 *
 * @author Chirath
 */

import groomify.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PetDAO {
    private Connection connection;
    
    public PetDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean addPet(Pet pet){
        try{
            String sql = "INSERT INTO pets (name, species, breed, coat_type, owner_id) VALUES (?,?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setString(3, pet.getBreed());
            statement.setString(4, pet.getCoatType());
            statement.setInt(5, pet.getOwnerId());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updatePet(Pet pet){
        try{
            String sql = "UPDATE pets SET name=?, species=?, breed=?, coat_type=? owner_id=? WHERE pet_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setString(3, pet.getBreed());
            statement.setString(4, pet.getCoatType());
            statement.setInt(5, pet.getOwnerId());
            statement.setInt(6, pet.getPetId());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deletePet(int petId){
        try{
            String sql = "DELETE FROM pets WHERE pet_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, petId);
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Pet> getAllPets(){
        
        ArrayList<Pet> petList = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM pets";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while (rst.next()) {
                petList.add(new Pet(rst.getInt("pet_id"), rst.getString("name"), rst.getString("species"), rst.getString("breed"), rst.getString("coat_type"), rst.getInt("owner_id")));
            }
            
            return petList;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
        
    public Pet searchPetByName(String name){
        try{
            String sql = "SELECT * FROM pets WHERE name=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, name);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return new Pet(rst.getInt("pet_id"), rst.getString("name"), rst.getString("species"), rst.getString("breed"), rst.getString("coat_type"), rst.getInt("owner_id"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
