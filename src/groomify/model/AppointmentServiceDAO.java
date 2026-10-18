/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import groomify.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class AppointmentServiceDAO {
    private Connection connection;
    
    public AppointmentServiceDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean addAppointmentService(AppointmentService appService){
        try{
            String sql = "INSERT INTO appointment_services (appointment_id, service_id, price) VALUES (?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appService.getAppointmentId());
            statement.setInt(2, appService.getServiceId());
            statement.setDouble(3, appService.getPrice());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updateAppointmentService(AppointmentService appService){
        try{
            String sql = "UPDATE appointment_services SET service_id=? price=? WHERE appointment_id=? AND service_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appService.getServiceId());
            statement.setDouble(2, appService.getPrice());
            statement.setInt(3, appService.getAppointmentId());
            statement.setInt(4, appService.getServiceId());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteAppointmentService(int appId){
        try{
            String sql = "DELETE FROM appointment_services WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appId);
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<AppointmentService> getServicesOfAppointment(int appId){
        
        ArrayList<AppointmentService> appServiceList = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM appointment_services WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appId);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                appServiceList.add(new AppointmentService(rst.getInt("appointment_id"), rst.getInt("service_id"), rst.getDouble("price")));
            }
            
            return appServiceList;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
//    public boolean deleteAppointmentServiceRecord(int appId, int serviceId){
//        try{
//            String sql = "DELETE FROM appointment_services WHERE appointment_id=? AND service_id=?";
//            
//            PreparedStatement statement = connection.prepareStatement(sql);
//            
//            statement.setInt(1, appId);
//            statement.setInt(2, serviceId);
//            
//            return statement.executeUpdate() > 0;
//            
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        
//        return false;
//    }
}
