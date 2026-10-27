/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groomify.model;

import java.util.ArrayList;

import groomify.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Chirath
 */
public class UpNextDAO {
    private Connection connection;
    
    public UpNextDAO(){
        connection = DBConnection.getInstance().getConnection();
    }
    
    public ArrayList<UpNext> getUpNext(){
        
        ArrayList<UpNext> dataList = new ArrayList<>();
        
        String sql = """
    SELECT
        a.appointment_id,
        a.date,
        a.time,
        p.name AS pet_name,
        GROUP_CONCAT(s.name ORDER BY s.name SEPARATOR ', ') AS services,
        a.status AS appointment_status
    FROM appointments a
    INNER JOIN pets p ON a.pet_id = p.pet_id
    LEFT JOIN appointment_services aps ON a.appointment_id = aps.appointment_id
    LEFT JOIN services s ON aps.service_id = s.service_id
    WHERE a.date = CURDATE()
      AND a.status = 'SCHEDULED'
    GROUP BY a.appointment_id, a.date, a.time, p.name, a.status
    ORDER BY a.time ASC
    """;
        
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            
            ResultSet rst = statement.executeQuery();
            
            while(rst.next()){
                dataList.add(new UpNext(rst.getTime("time").toLocalTime(), rst.getString("pet_name"), rst.getString("services"), rst.getString("appointment_status")));
            }
            
            return dataList;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
}
