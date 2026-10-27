/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Chirath
 */
public class UpNext {
    private LocalTime time;
    private String pet;
    private String services;
    private String status;

    public UpNext(LocalTime time, String pet, String services, String status) {
        this.time = time;
        this.pet = pet;
        this.services = services;
        this.status = status;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
