/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

/**
 *
 * @author Chirath
 */
public class AppointmentService {
    private int appointmentId;
    private int serviceId;
    private double price;

    public AppointmentService(int appointmentId, int serviceId, double price) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.price = price;
    }

    public AppointmentService(int serviceId, double price) {
        this.serviceId = serviceId;
        this.price = price;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
