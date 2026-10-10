/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.db;

/**
 *
 * @author Chirath
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    
    private DBConnection(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groomify","root","");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static DBConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
