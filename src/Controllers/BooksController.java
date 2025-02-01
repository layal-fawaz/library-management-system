/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Book;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LibririanStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.allBooksStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.books;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class BooksController implements Initializable {

    @FXML
    private TextField bookFilter;
    @FXML
    private TableView<Book> tableViewBook;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> catgeoryColumn;
    @FXML
    private TableColumn<Book, String> isbanColumn;
    @FXML
    private TableColumn<Book, Integer> copyCountColumn;
    @FXML
    private TableColumn<Book, Integer> pageCountColumn;
    @FXML
    private TableColumn<Book, String> languageColumn;
    @FXML
    private TableColumn<Book, ImageView> BookimageViewColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //------------set cell data for book table
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
        isbanColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("PageCount"));
        copyCountColumn.setCellValueFactory(new PropertyValueFactory<>("CopyCount"));
        catgeoryColumn.setCellValueFactory(new PropertyValueFactory<>("Catgeory"));
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("Language"));

        BookimageViewColumn.setCellValueFactory(cellData -> {
            String profileImagePath = cellData.getValue().getBookImagePath();
            ImageView userImage;

            try {
                URL imageUrl = getClass().getResource(profileImagePath);
                if (imageUrl != null) {
                    userImage = new ImageView(new Image(imageUrl.toExternalForm()));
                } else {
                    userImage = new ImageView(new Image(getClass().getResource("/images/images.jpg").toExternalForm()));
                }
            } catch (Exception e) {
                userImage = new ImageView(new Image(getClass().getResource("/images/images.jpg").toExternalForm()));
            }

            userImage.setFitHeight(30);
            userImage.setFitWidth(30);
            return new SimpleObjectProperty<>(userImage);
        });
        tableViewBook.setItems(books);

      bookFilter.textProperty().addListener(((observable, oldValue, newValue) -> {
            filterTable(newValue);
        }));
    }

    public void filterTable(String containWord) {
    ObservableList<Book> filteredBooks = FXCollections.observableArrayList();
    
    for (Book book : books) {
        if (book.getTitle().toLowerCase().contains(containWord.toLowerCase())
                || book.getAuthor().toLowerCase().contains(containWord.toLowerCase())
                || book.getIsbn().toLowerCase().contains(containWord.toLowerCase())
                ||book.getPageCount().contains(containWord)
                ||book.getCopyCount().contains(containWord)
                || book.getCatgeory().toLowerCase().contains(containWord)
                || book.getLanguage().toLowerCase().contains(containWord)) {
            
            filteredBooks.add(book);
        }
    }
    
    tableViewBook.setItems(filteredBooks);
}

    @FXML
    private void clear(ActionEvent event) {
        bookFilter.clear();
        
    }


    @FXML
    private void logOut(MouseEvent event) {
        allBooksStage.close();
        LibririanStage.show();
    }

}
