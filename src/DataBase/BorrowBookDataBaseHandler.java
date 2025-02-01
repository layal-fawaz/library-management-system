/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Model.BorrowBookDetailes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author awadallah
 */
public class BorrowBookDataBaseHandler {

    public static void addBorrowBookDetailes(BorrowBookDetailes br) {
        String query = "INSERT INTO borrowbooksdetails (userid, username, userimage, bookid, booktitle, bookimage, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DataBaseConnection.getInstance(); // تأكد من استخدام try-with-resources
                PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, br.getUserId());
            pstmt.setString(2, br.getUserName());
            pstmt.setString(3, br.getUserImage());
            pstmt.setInt(4, br.getBookId());
            pstmt.setString(5, br.getBookTitle());
            pstmt.setString(6, br.getBookImage());
            pstmt.setString(7, br.getStatus());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to save borrow details: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public static void updateStatus(int userId, int bookId, String updatedStatus) {
        Connection con = DataBaseConnection.getInstance();

        String query = "UPDATE borrowbooksdetails SET status = ? WHERE userid = ? AND bookid=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, updatedStatus);
            ps.setInt(2, userId);
            ps.setInt(3, bookId);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<BorrowBookDetailes> getBorrowDetails() {
        ObservableList<BorrowBookDetailes> borrowDetailsList = FXCollections.observableArrayList();
        String query = "SELECT * FROM borrowbooksdetails";

        try (Connection con = DataBaseConnection.getInstance(); 
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BorrowBookDetailes br = new BorrowBookDetailes(
                        rs.getInt("userid"),
                        rs.getString("username"),
                        rs.getString("userimage"),
                        rs.getInt("bookid"),
                        rs.getString("booktitle"),
                        rs.getString("bookimage"),
                        rs.getString("status")
                );
                borrowDetailsList.add(br);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to retrieve borrow details: " + e.getMessage());
            alert.showAndWait();
        }

        return borrowDetailsList;
    }

}
