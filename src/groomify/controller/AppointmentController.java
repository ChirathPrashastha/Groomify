/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.AppointmentDAO;
import groomify.model.Appointment;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class AppointmentController {
    private AppointmentDAO appointmentDAO;
    
    public AppointmentController(){
        appointmentDAO = new AppointmentDAO();
    }
    
    public boolean addAppointment(Appointment appointment){
        return appointmentDAO.addAppointment(appointment);
    }
    
    public boolean updateAppointment(Appointment appointment){
        return appointmentDAO.updateAppointment(appointment);
    }
    
    public boolean deleteAppointment(int appId){
        return appointmentDAO.deleteAppointment(appId);
    }
    
    public boolean cancelAppointment(int appId){
        return appointmentDAO.cancelAppointment(appId);
    }
    
    public boolean completeAppointment(int appId){
        return appointmentDAO.completeAppointment(appId);
    }
    
    public ArrayList<Appointment> getAllAppointments(){
        return appointmentDAO.getAllAppointments();
    }
    
    public int getLastAppointmentId(){
        return appointmentDAO.getLastAppointmentId();
    }
    
    public int getTodaysAppointmentsCount(){
        return appointmentDAO.getTodaysAppointmentsCount();
    }
}
