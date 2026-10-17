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

public class ServiceDAO {
    private Connection connection;
    
    public ServiceDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean addService(Service service){
        try{
            
            String sql = "INSERT INTO services (name, description, price, status) VALUES (?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, service.getName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setString(4, service.getStatus());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updateService(Service service){
        try{
            
            String sql = "UPDATE services SET name=? , description=? , price=? , status=? WHERE service_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, service.getName());
            statement.setString(2, service.getDescription());
            statement.setDouble(3, service.getPrice());
            statement.setString(4, service.getStatus());
            statement.setInt(5, service.getServiceId());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteService(int serviceId){
        try{
            
            String sql = "DELETE FROM services WHERE service_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, serviceId);
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Service> getAllServices(){
        ArrayList<Service> serviceList = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM services";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                serviceList.add(new Service(rst.getInt("service_id"), rst.getString("name"), rst.getString("description"), rst.getDouble("price"), rst.getString("status")));
            }
            
            return serviceList;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public Service searchServiceByName(String name){
        try{
            
            String sql = "SELECT * FROM services WHERE name=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, name);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return new Service(rst.getInt("service_id"), rst.getString("name"), rst.getString("description"), rst.getDouble("price"), rst.getString("status"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
