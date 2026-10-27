/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.ServiceDAO;
import groomify.model.Service;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */

public class ServiceController {
    private ServiceDAO serviceDAO;
    
    public ServiceController(){
        serviceDAO = new ServiceDAO();
    }
    
    public boolean addService(Service service){
        return serviceDAO.addService(service);
    }
    
    public boolean updateService(Service service){
        return serviceDAO.updateService(service);
    }
    
    public boolean deleteService(int serviceId){
        return serviceDAO.deleteService(serviceId);
    }
    
    public Service searchService(Object id){
        return serviceDAO.seachService(id);
    }
    
    public ArrayList<Service> getAllServices(){
        return serviceDAO.getAllServices();
    }
    
    public Service searchServiceByName(String name){
        return serviceDAO.searchServiceByName(name);
    }
    
    public Service searchServiceById(int serviceId){
        return serviceDAO.searchServiceById(serviceId);
    }
}
