/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.InvoiceDAO;
import groomify.model.Invoice;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class InvoiceController {
    private InvoiceDAO invoiceDAO;
    
    public InvoiceController(){
        invoiceDAO = new InvoiceDAO();
    }
    
    public boolean addInvoice(Invoice invoice){
        return invoiceDAO.addInvoice(invoice);
    }
    
    public boolean updateInvoice(double  tot, int appId){
        return invoiceDAO.updateInvoice(tot, appId);
    }
    
    public boolean deleteInvoice(int invoiceId){
        return invoiceDAO.deleteInvoice(invoiceId);
    }
    
    public ArrayList<Invoice> getAllInvoices(){
        return invoiceDAO.getAllInvoices();
    }
    
    public ArrayList<Invoice> getPaidInvoices(){
        return invoiceDAO.getPaidInvoicecs();
    }
    
    public ArrayList<Invoice> getPendingInvoices(){
        return invoiceDAO.getPendingInvoicecs();
    }
    
    public boolean markAsPaid(Invoice invoice){
        return invoiceDAO.markAsPaid(invoice);
    }
    
    public double getTodaysRevenue(){
        return invoiceDAO.getTodaysRevenue();
    }
    
    public int getPendingPayemntCount(){
        return invoiceDAO.getPendingPaymentCount();
    }
}
