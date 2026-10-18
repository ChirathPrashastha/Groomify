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
public class AppointmentDAO {
    private Connection connection;
    
    public AppointmentDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean addAppointment(Appointment appointment){
        try{
            String sql = "INSERT INTO appointments (pet_id, date, time, status, created_by) VALUES (?,?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appointment.getPetId());
            statement.setDate(2, java.sql.Date.valueOf(appointment.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(appointment.getTime()));
            statement.setString(4, appointment.getStatus());
            statement.setInt(5, appointment.getCreatedBy());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updateAppointment(Appointment appointment){
        try{
            String sql = "UPDATE appointments SET pet_id=?, date=?, time=?, status=? WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appointment.getPetId());
            statement.setDate(2, java.sql.Date.valueOf(appointment.getDate()));
            statement.setTime(3, java.sql.Time.valueOf(appointment.getTime()));
            statement.setString(4, appointment.getStatus());
            statement.setInt(5, appointment.getAppointmentId());
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteAppointment(int appointmentId){
        try{
            String sql = "DELETE FROM appointments WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, appointmentId);
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean cancelAppointment(int appId){
        try{
            String sql = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appId);
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean completeAppointment(int appId){
        try{
            String sql = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, appId);
            
            return statement.executeUpdate() > 0;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Appointment> getAllAppointments(){
        
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM appointments";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                appointmentList.add(new Appointment(rst.getInt("appointment_id"), rst.getInt("pet_id"), rst.getDate("date").toLocalDate(), rst.getTime("time").toLocalTime(), rst.getString("status"), rst.getInt("created_by")));
            }
            
            return appointmentList;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public int getLastAppointmentId(){
        try{
            String sql = "SELECT MAX(appointment_id) AS last_id FROM appointments";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return rst.getInt("last_id");
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return 0;
    }
}
