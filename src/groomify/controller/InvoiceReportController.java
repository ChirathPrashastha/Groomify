/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.controller;

import groomify.model.InvoiceReport;
/**
 *
 * @author Chirath
 */
public class InvoiceReportController {
    private InvoiceReport report;
    
    public InvoiceReportController(){
        report = new InvoiceReport();
    }
    
    public void generateBill(int invoiceId){
        report.generateInvoice(invoiceId);
    }
}
