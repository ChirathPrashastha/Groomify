/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package groomify;

import groomify.db.DBConnection;
import groomify.view.FrameLogin;

/**
 *
 * @author Chirath
 */

import java.sql.Connection;

public class Groomify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Connection con = DBConnection.getInstance().getConnection();
       
       try{
            if(!con.isClosed()){
                System.out.println("Database connection established successfully...");
            }else{
                System.out.println("Failed to connect the database!");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
        FrameLogin login = new FrameLogin();
        login.setVisible(true);
    }
    
}
