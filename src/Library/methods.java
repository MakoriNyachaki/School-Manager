/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author Start_a_Way
 */
import Students.DbConnect;
import Library.Return;
import java.sql.*;

public class methods {
    
    Connection conn  = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    
    public methods() {       
        conn =new DbConnect().DbConnect();
    }
    public void oneUser(){
    String sql = "";
     
        try {
            pstmt = conn.prepareStatement(sql);
           
        } catch (Exception e) {
        }
    }
    
}
