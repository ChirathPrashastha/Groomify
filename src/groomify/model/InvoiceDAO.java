/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import groomify.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chirath
 */
public class InvoiceDAO {
    private Connection connection;
    
    public InvoiceDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public boolean addInvoice(Invoice invoice){
        try{
            
            String sql = "INSERT INTO invoices (appointment_id, total, payment_method, status) VALUES (?,?,?,?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, invoice.getAppointmentId());
            statement.setDouble(2, invoice.getTotal());
            statement.setString(3, "PENDING");
            statement.setString(4, invoice.getStatus());
            
            return statement.executeUpdate() > 0;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean updateInvoice(double total, int appId){
        try{
            
            String sql = "UPDATE invoices SET total=? WHERE appointment_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setDouble(1, total);
            statement.setInt(2, appId);
            
            return statement.executeUpdate() > 0;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public boolean deleteInvoice(int invoiceId){
        try{
            
            String sql = "DELETE FROM invoices WHERE invoice_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, invoiceId);
            
            return statement.executeUpdate() > 0;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<Invoice> getAllInvoices(){
        
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM invoices";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                invoiceList.add(new Invoice(rst.getInt("invoice_id"), rst.getInt("appointment_id"), rst.getDouble("total"), rst.getString("payment_method"), rst.getString("status")));
            }
            
            return invoiceList;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<Invoice> getPaidInvoicecs(){
        
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM invoices WHERE status='PAID'";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                invoiceList.add(new Invoice(rst.getInt("invoice_id"), rst.getInt("appointment_id"), rst.getDouble("total"), rst.getString("payment_method"), rst.getString("status")));
            }
            
            return invoiceList;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<Invoice> getPendingInvoicecs(){
        
        ArrayList<Invoice> invoiceList = new ArrayList<>();
        
        try{
            
            String sql = "SELECT * FROM invoices WHERE status='PENDING'";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                invoiceList.add(new Invoice(rst.getInt("invoice_id"), rst.getInt("appointment_id"), rst.getDouble("total"), rst.getString("payment_method"), rst.getString("status")));
            }
            
            return invoiceList;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    public boolean markAsPaid(Invoice invoice){
        try{
            
            String sql = "UPDATE invoices SET payment_method=?, status='PAID' WHERE invoice_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, invoice.getPaymentMethod());
            statement.setInt(2, invoice.getInvoiceId());
            
            return statement.executeUpdate() > 0;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public double getTodaysRevenue(){
        try{
            
            String sql = "SELECT SUM(total) AS revenue FROM invoices JOIN appointments ON invoices.appointment_id = appointments.appointment_id WHERE appointments.date = CURDATE() AND invoices.status='PAID'";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return rst.getDouble("revenue");
            }
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return 0.0;
    }
    
    public int getPendingPaymentCount(){
        try{
            
            String sql = "SELECT COUNT(invoice_id) AS pending_count FROM invoices WHERE status='PENDING';";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return rst.getInt("pending_count");
            }
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return 0;
    }
}
