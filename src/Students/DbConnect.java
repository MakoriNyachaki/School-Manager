/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Start_a_Way
 */
public class DbConnect {

    Connection conn;
    public final String DbName = "sms";
    public final String Name = "admin";
    public final String url = "jdbc:mysql://localhost:3306/";
    public final String pass = "admin";

    public Connection DbConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + DbName, Name, pass);

            if (conn != null) {
                System.out.println("Connected successfully");
            } else {
                System.out.println("No connection established");
            }

        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        DbConnect connect = new DbConnect();
    }

}
