/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.BorrowBookDetailes;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LibririanStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.bookStatistic;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class BookStatistic implements Initializable {

    @FXML
    private TableView<BorrowBookDetailes> statisticTableView;
    @FXML
    private TableColumn<BorrowBookDetailes, Integer> userId;
    @FXML
    private TableColumn<BorrowBookDetailes, Integer> userName;
    @FXML
    private TableColumn<BorrowBookDetailes, ImageView> userImage;
    @FXML
    private TableColumn<BorrowBookDetailes, String> bookId;
    @FXML
    private TableColumn<BorrowBookDetailes, String> bookTitleCplumn;
    @FXML
    private TableColumn<BorrowBookDetailes, ImageView> bookImageColumn;
    @FXML
    private TextField borrowFilter;
    private String filterClear = "";
    private String selectedStatus = "All";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userImage.setCellValueFactory(new PropertyValueFactory<>("userImage"));
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookTitleCplumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        bookImageColumn.setCellValueFactory(new PropertyValueFactory<>("bookImage"));

        bookImageColumn.setCellValueFactory(cellData -> {
            ImageView bookImage = new ImageView(cellData.getValue().getBookImage());
            bookImage.setFitHeight(30);
            bookImage.setFitWidth(30);
            return new SimpleObjectProperty<>(bookImage);
        });

        userImage.setCellValueFactory(cellData -> {
            ImageView userImage = new ImageView(cellData.getValue().getUserImage());
            userImage.setFitHeight(30);
            userImage.setFitWidth(30);
            return new SimpleObjectProperty<>(userImage);
        });
        statisticTableView.setItems(SceneBuilderLibrarySystem.borrowBooksDetailes);

        borrowFilter.textProperty().addListener(((observable, oldValue, newValue) -> {
            filterClear = newValue;
            filterTable(newValue);
        }));
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public void setTableBookData(ObservableList<BorrowBookDetailes> borrowBooksDetailes) {
        ObservableList<BorrowBookDetailes> filteredBooks = FXCollections.observableArrayList();

        for (BorrowBookDetailes b : borrowBooksDetailes) {
            if (selectedStatus.equals("Borrowed")) {
                if ("Pending".equals(b.getStatus()) || "Approved".equals(b.getStatus())) {
                    filteredBooks.add(b);
                }
            } else if (selectedStatus.equals(b.getStatus())) {
                filteredBooks.add(b);
            }
        }

        statisticTableView.setItems(filteredBooks);
    }

    public void filterTable(String containWord) {
        ObservableList<BorrowBookDetailes> filteredBorrowDetails = FXCollections.observableArrayList();

        for (BorrowBookDetailes bd : SceneBuilderLibrarySystem.borrowBooksDetailes) {
            boolean status = selectedStatus.equals("Borrowed")
                    ? ("Pending".equals(bd.getStatus()) || "Approved".equals(bd.getStatus())) : selectedStatus.equals(bd.getStatus());

            boolean search = (String.valueOf(bd.getUserId()).contains(containWord)
                    || bd.getUserName().toLowerCase().contains(containWord)
                    || String.valueOf(bd.getBookId()).toLowerCase().contains(containWord)
                    || bd.getBookTitle().toLowerCase().contains(containWord));

            if (status && search) {
                filteredBorrowDetails.add(bd);
            }
        }

        statisticTableView.setItems(filteredBorrowDetails);
    }

    @FXML
    private void clear(ActionEvent event) {
        borrowFilter.clear();
    }

    @FXML
    private void logOut(MouseEvent event) {
        bookStatistic.hide();
        LibririanStage.show();
    }

    @FXML
    private void searchBook(MouseEvent event) {
    }

}
