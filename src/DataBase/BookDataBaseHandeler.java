/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Model.Book;
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
public class BookDataBaseHandeler {
public static ObservableList<Book> getBooksData() {
    ObservableList<Book> tempBooks = FXCollections.observableArrayList();
    String query = "SELECT * FROM books";
    
    try (Connection con = DataBaseConnection.getInstance();
         PreparedStatement ps = con.prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            tempBooks.add(new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("isbn"),
                rs.getString("publishDate"),
                rs.getString("pageCount"),
                rs.getString("copyCount"),
                rs.getString("publisher"),
                rs.getString("bookImagePath"),
                rs.getString("catgeory"),
                rs.getString("language")
            ));
        }
    } catch (SQLException ex) {
        Logger.getLogger(BookDataBaseHandeler.class.getName()).log(Level.SEVERE, null, ex.getMessage());
    }
    
    return tempBooks;
}

public static void addBook(Book b) {
    String query = "INSERT INTO books (title, author, isbn, publishDate, pageCount, copyCount, publisher, bookImagePath, catgeory, language) VALUES (?,?,?,?,?,?,?,?,?,?)";
    
    try (Connection con = DataBaseConnection.getInstance();
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setString(1, b.getTitle());
        ps.setString(2, b.getAuthor());
        ps.setString(3, b.getIsbn());
        ps.setString(4, b.getPublishDate());
        ps.setString(5, b.getPageCount());
        ps.setString(6, b.getCopyCount());
        ps.setString(7, b.getPublisher());
        ps.setString(8, b.getBookImagePath());
        ps.setString(9, b.getCatgeory());
        ps.setString(10, b.getLanguage());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Add book failed: " + ex.getMessage());
    }
}

public static void updateBook(Book b) {
    String query = "UPDATE books SET title=?, author=?, isbn=?, publishDate=?, pageCount=?, copyCount=?, publisher=?, bookImagePath=?, catgeory=?, language=? WHERE id=?";
    
    try (Connection con = DataBaseConnection.getInstance();
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setString(1, b.getTitle());
        ps.setString(2, b.getAuthor());
        ps.setString(3, b.getIsbn());
        ps.setString(4, b.getPublishDate());
        ps.setString(5, b.getPageCount());
        ps.setString(6, b.getCopyCount());
        ps.setString(7, b.getPublisher());
        ps.setString(8, b.getBookImagePath());
        ps.setString(9, b.getCatgeory());
        ps.setString(10, b.getLanguage());
        ps.setInt(11, b.getId());
        
        ps.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Update book failed: " + ex.getMessage());
    }
}

public static void deleteBook(Book b) {
    String query = "DELETE FROM books WHERE id=?";
    
    try (Connection con = DataBaseConnection.getInstance();
         PreparedStatement ps = con.prepareStatement(query)) {
        
        ps.setInt(1, b.getId());
        ps.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Delete book failed: " + ex.getMessage());
    }
}

}
