/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author awadallah
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DataBaseConnection {

    public static Connection conn = null;

    public static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Driver Not Found: " + e.getMessage());
        }

    }

    public static Connection getInstance() {
        if (conn == null) {
            try {
                loadDriver();
               conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem", "root", "");
                 JOptionPane.showMessageDialog(null, "Connection Establish.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection Faild: " + e.getMessage());
            }
        }
           return conn;
    }}
//public class DataBaseConnection {
//
//    private static Connection con = null;
//
//    private static void loadDriver() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Driver not found: " + e.getMessage());
//        }
//    }
//
//    public static Connection getInstance() {
//        try {
//            if (con == null || con.isClosed()) {
//                loadDriver();
//                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/librarymanagementsystem", "root", "");
//                JOptionPane.showMessageDialog(null, "Connection established");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Connection failed: " + ex.getMessage());
//        }
//        return con;
//    }
//
//    public static void closeConnection() {
//        try {
//            if (con != null && !con.isClosed()) {
//                con.close();
//                JOptionPane.showMessageDialog(null, "Connection closed");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error closing connection: " + ex.getMessage());
//        }
//    }
//}
//  
//
//    

