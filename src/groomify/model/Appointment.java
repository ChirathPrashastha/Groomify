/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Chirath
 */
public class Appointment {
    private int appointmentId;
    private int petId;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private int createdBy;

    public Appointment(int appointmentId, int petId, LocalDate date, LocalTime time, String status, int createdBy) {
        this.appointmentId = appointmentId;
        this.petId = petId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.createdBy = createdBy;
    }

    public Appointment(int petId, LocalDate date, LocalTime time, String status, int createdBy) {
        this.petId = petId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.createdBy = createdBy;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    
}
