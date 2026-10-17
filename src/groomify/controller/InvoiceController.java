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
    
    public boolean updateInvoice(Invoice invoice){
        return invoiceDAO.updateInvoice(invoice);
    }
    
    public boolean deleteInvoice(int invoiceId){
        return invoiceDAO.deleteInvoice(invoiceId);
    }
    
    public ArrayList<Invoice> getAllInvoices(){
        return invoiceDAO.getAllInvoices();
    }
}
