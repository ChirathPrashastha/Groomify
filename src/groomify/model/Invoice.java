/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

/**
 *
 * @author Chirath
 */
public class Invoice {
    private int invoiceId;
    private int appointmentId;
    private double total;
    private String paymentMethod;
    private String status;

    public Invoice(int invoiceId, int appointmentId, double total, String paymentMethod, String status) {
        this.invoiceId = invoiceId;
        this.appointmentId = appointmentId;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Invoice(int appointmentId, double total, String paymentMethod, String status) {
        this.appointmentId = appointmentId;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
