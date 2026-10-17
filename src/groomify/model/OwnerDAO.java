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

public class OwnerDAO {
    
    private Connection connection;
    
    public OwnerDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean addOwner(Owner owner){
        try{
            String sql = "INSERT INTO owners (full_name, contact, address, email) VALUES (?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, owner.getName());
            statement.setString(2, owner.getContact());
            statement.setString(3, owner.getAddress());
            statement.setString(4, owner.getEmail());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updateOwner(Owner owner){
        try{
            String sql = "UPDATE owners SET full_name=? , contact=? , address=? , email=? WHERE owner_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, owner.getName());
            statement.setString(2, owner.getContact());
            statement.setString(3, owner.getAddress());
            statement.setString(4, owner.getEmail());
            statement.setInt(5, owner.getOwnerId());
            
            boolean isSuccess = statement.executeUpdate() > 0;
            
            if(isSuccess){
                return true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteOwner(int ownerId){
        try{
            String sql = "DELETE FROM owners WHERE owner_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, ownerId);
            
            boolean isSuccess = statement.executeUpdate() > 0;
            
            if(isSuccess){
                return true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Owner> getAllOwners(){
        ArrayList<Owner> ownerList = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM owners";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                ownerList.add(new Owner(rst.getInt("owner_id"), rst.getString("full_name"), rst.getString("contact"), rst.getString("address"), rst.getString("email")));
            }
            
            return ownerList;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<String> getAllOwnerNames(){
        ArrayList<String> nameList = new ArrayList<>();
        
        try{
            String sql = "SELECT full_name FROM owners";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                nameList.add(rst.getString("full_name"));
            }
            
            return nameList;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public Owner searchByName(String name){
        try{
            String sql = "SELECT * FROM owners WHERE full_name=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, name);
            
            ResultSet rst = statement.executeQuery();
            
            return new Owner(rst.getInt("owner_id"), rst.getString("full_name"), rst.getString("contact"), rst.getString("address"), rst.getString("email"));
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public int getOwnerIdbyOwnerName(String name){
        try{
            String sql = "SELECT owner_id FROM owners WHERE full_name=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, name);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                return rst.getInt("owner_id");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return 0;
    }
    
    public Owner getOwnerByOwnerId(int ownerId){
        try{
            String sql = "SELECT * FROM owners WHERE owner_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, ownerId);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return new Owner(rst.getInt("owner_id"), rst.getString("full_name"), rst.getString("contact"), rst.getString("address"), rst.getString("email"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
