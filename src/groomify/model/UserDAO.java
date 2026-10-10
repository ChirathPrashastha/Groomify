/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import groomify.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Chirath
 */
public class UserDAO {
    private Connection connection;
    
    public UserDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public User checkCredentials(String username, String password){
        try{
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rst = statement.executeQuery();
            
            if(rst.next()){
                return new User(rst.getInt("user_id"), rst.getString("full_name"), rst.getString("username"), rst.getString("password"), rst.getString("role"));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
