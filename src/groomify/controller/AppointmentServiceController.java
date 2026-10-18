/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.AppointmentServiceDAO;
import groomify.model.AppointmentService;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class AppointmentServiceController {
    private AppointmentServiceDAO appServiceDAO;
    
    public AppointmentServiceController(){
        appServiceDAO = new AppointmentServiceDAO();
    }
    
    public boolean addAppointmentService(AppointmentService appService){
        return appServiceDAO.addAppointmentService(appService);
    }
    
    public boolean updateAppointmentService(AppointmentService appService){
        return appServiceDAO.updateAppointmentService(appService);
    }
    
    public boolean deleteAppointmentService(int appId){
        return appServiceDAO.deleteAppointmentService(appId);
    }
    
    public ArrayList<AppointmentService> getServicesOfAppointment(int appId){
        return appServiceDAO.getServicesOfAppointment(appId);
    }
}
