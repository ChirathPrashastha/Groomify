/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

/**
 *
 * @author Chirath
 */
public class Service {
    private int serviceId;
    private String name;
    private String description;
    private double price;
    private String status;

    public Service(int serviceId, String name, String description, double price, String status) {
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public Service(String name, String description, double price, String status) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
