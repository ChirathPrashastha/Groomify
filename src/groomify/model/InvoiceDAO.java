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
                invoiceList.add(new Invoice(rst.getInt("invoicec_id"), rst.getInt("appointment_id"), rst.getDouble("total"), rst.getString("payement_method"), rst.getString("status")));
            }
            
            return invoiceList;
                    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
