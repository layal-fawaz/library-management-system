/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author awadallah
 */
public class UserDataBaseHandeler {

    public static ObservableList<User> getUsersData() {
        Connection con = DataBaseConnection.getInstance();
        ObservableList<User> tempUsers = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
                ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tempUsers.add(new User(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getString("userName"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("role"),
                        rs.getString("profileImagePath")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDataBaseHandeler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tempUsers;
    }

    public static void addUser(User u) {
        Connection con = DataBaseConnection.getInstance();
        String query = "INSERT INTO users (fullName, userName, password, email, phoneNumber, role, profileImagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, u.getFullName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPhoneNumber());
            ps.setString(6, u.getRole());
            ps.setString(7, u.getProfileImagePath());

            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Add user failed: " + ex.getMessage());
        }
    }

    public static void updateUser(User u) {
        Connection con = DataBaseConnection.getInstance();
        String query = "UPDATE users SET fullName = ?, userName = ?, password = ?, email = ?, phoneNumber = ?, role = ?, profileImagePath = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, u.getFullName());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPhoneNumber());
            ps.setString(6, u.getRole());
            ps.setString(7, u.getProfileImagePath());
            ps.setInt(8, u.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update user failed: " + ex.getMessage());
        }
    }

    public static void deleteUser(User u) {
        Connection con = DataBaseConnection.getInstance();
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, u.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Delete user failed: " + ex.getMessage());
        }
    }
    
}
