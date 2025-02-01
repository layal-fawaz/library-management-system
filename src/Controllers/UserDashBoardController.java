/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.AdminDashBoardController.bookImages;
import static Controllers.AdminDashBoardController.imageBookName;
import DataBase.BookDataBaseHandeler;
import DataBase.BorrowBookDataBaseHandler;
import Model.Book;
import Model.BorrowBook;
import Model.BorrowBookDetailes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LibririanStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LoginStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.UserStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.books;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.borrowBooks;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.borrowBooksDetailes;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.categories;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.userLogin;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.users;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class UserDashBoardController implements Initializable {
    
    @FXML
    private Label homeSideBar;
    @FXML
    private Label userManagementSideBar;
    @FXML
    private Label bookManagementSideBar;
    @FXML
    private AnchorPane homeAnchor;
    // private AnchorPane userManagementAnchor;
    @FXML
    private AnchorPane BookManagementAnchor;
    @FXML
    private ImageView userProfileImage;
    @FXML
    private Label userProfileLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField titleTxt;
    @FXML
    private Label publishDateLabel;
    @FXML
    private TextField publishDateTxt;
    @FXML
    private Label publisherLabel;
    @FXML
    private TextField publisherTxt;
    @FXML
    private Label aoutherLabel;
    @FXML
    private TextField aoutherTxt;
    @FXML
    private Label copyCountLabel;
    @FXML
    private TextField copyCountTxt;
    @FXML
    private Label pageCountLabel;
    @FXML
    private TextField pageCountTxt;
    @FXML
    private Label isbnLabel;
    @FXML
    private TextField isbnTxt;
    @FXML
    private Label categoryLabel;
    @FXML
    private TextField categoryTxt;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private ComboBox<String> bookComboBox;
    @FXML
    private ImageView bookImageViewUser;
    public static int book_Id = -1;
    @FXML
    private Button borrowButton;
    @FXML
    private AnchorPane borrowBookAnchor;
    @FXML
    private HBox hbox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homeSideBar.getStyleClass().add("sideBarLabel");
        userManagementSideBar.getStyleClass().add("sideBarLabel");
        bookManagementSideBar.getStyleClass().add("sideBarLabel");
        borrowButton.setStyle("-fx-background-color:#90EE90;");
        borrowButton.setDisable(true);
        
        setSelectedSideBar(homeSideBar, homeAnchor);
        //--------------------imageView

        userProfileImage.setImage(new Image(userLogin.getProfileImagePath()));
        userProfileLabel.setText(userLogin.getFullName());
        
        categoryComboBox.getItems().addAll(categories);
        BorrowBooksDisplay();
    }
    
    private void BorrowBooksDisplay() {
    hbox.getChildren().clear();  
    for (BorrowBookDetailes br : borrowBooksDetailes) {
        if (br != null && br.getUserId() == userLogin.getId()) {
            if (br.getStatus() != null && (br.getStatus().equals("Pending") || br.getStatus().equals("Approved") || br.getStatus().equals("Returned"))) {
                VBox vboxNew = new VBox();
                vboxNew.getStyleClass().add("vbox");
                ImageView img = new ImageView(br.getBookImage());
                img.setFitHeight(50);
                img.setFitWidth(50);
                
                Label titleL = new Label(br.getBookTitle());
                Label dateL = new Label("Deliver Date :"+br.getReturnDate().plusDays(30));
                Label statusL = new Label("Status: " + br.getStatus());
                Button statusBut = new Button();
                
                if (br.getStatus().equals("Pending")) {
                    statusBut.setText("Pending");
                    statusBut.setStyle("-fx-background-color:yellow;");
                    statusBut.setDisable(true);
                } else if (br.getStatus().equals("Approved")) {
                    statusBut.setText("Return");
                    statusBut.setOnAction(e -> {
                        vboxNew.setVisible(false);
                        borrowBooksDetailes.remove(br);
                        hbox.getChildren().remove(vboxNew);
                    });
                }
                
                vboxNew.getChildren().addAll(img, titleL, dateL, statusL, statusBut);
                hbox.getChildren().add(vboxNew);
            }
        }
    }
    hbox.setSpacing(30); 
}
    @FXML
    private void showHomeSidebar(MouseEvent event) {
        setSelectedSideBar(homeSideBar, homeAnchor);
    }
    
    @FXML
    private void showUserManagementSideBar(MouseEvent event) {
        setSelectedSideBar(userManagementSideBar, borrowBookAnchor);
        
    }
    
    @FXML
    private void showBookManagementSideBar(MouseEvent event) {
        setSelectedSideBar(bookManagementSideBar, BookManagementAnchor);
        
    }
    
    public void setSelectedSideBar(Label selectedLabel, AnchorPane anchor) {
        homeSideBar.getStyleClass().remove("selected");
        userManagementSideBar.getStyleClass().remove("selected");
        bookManagementSideBar.getStyleClass().remove("selected");
        selectedLabel.getStyleClass().add("selected");

        //------------------
        homeAnchor.setVisible(false);
        BookManagementAnchor.setVisible(false);
        borrowBookAnchor.setVisible(false);
        
        anchor.setVisible(true);
    }
    
    @FXML
    private void logOut(MouseEvent event) {
        UserStage.close();
        LoginStage.show();
    }
    
    @FXML
    private void filterBookofCategory(ActionEvent event) {
        String selectedCategory = categoryComboBox.getValue();
        bookComboBox.getItems().clear();
        for (Book b : books) {
            if (b.getCatgeory().equals(selectedCategory)) {
                bookComboBox.getItems().add(b.getId() + "-" + b.getTitle());
            }
        }
    }
    
    @FXML
    private void clearBook(ActionEvent event) {
        bookComboBox.getStyleClass().removeAll("searchBorderRed", "searchBorderGreen");
        categoryComboBox.getStyleClass().removeAll("searchBorderRed", "searchBorderGreen");
        clearInputs();
    }
    
    @FXML
    private void borrowBook(ActionEvent event) {
        if (book_Id > 0) {
            
            Book b = getBookDetaileds(book_Id);
            if (b != null) {
                borrowBooks.add(new BorrowBook(userLogin.getId(), book_Id));
                
                BorrowBookDetailes br = new BorrowBookDetailes(userLogin.getId(), userLogin.getUserName(), userLogin.getProfileImagePath(),
                        b.getId(), b.getTitle(), b.getBookImagePath(), "Pending");
                
                borrowBooksDetailes.add(br);
                BorrowBookDataBaseHandler.addBorrowBookDetailes(br);
                        BorrowBooksDisplay();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "your request is pending");
                alert.showAndWait();
                clearBook(event);
            }
        }
        
    }
    
    @FXML
    private void searchBook(ActionEvent event) {
        
        String selectedCategory = categoryComboBox.getValue();
        String selectedBookV = bookComboBox.getValue();
        
        bookComboBox.getStyleClass().removeAll("searchBorderRed", "searchBorderGreen");
        categoryComboBox.getStyleClass().removeAll("searchBorderRed", "searchBorderGreen");
        
        if ((selectedBookV == null || selectedBookV.isEmpty()) && (selectedCategory == null || selectedCategory.isEmpty())) {
            categoryComboBox.getStyleClass().add("searchBorderRed");
            bookComboBox.getStyleClass().add("searchBorderRed");
            
        } else {
            if (selectedCategory != null && !selectedCategory.isEmpty()) {
                categoryComboBox.getStyleClass().add("searchBorderGreen");
            }
            
            if (selectedBookV != null && !selectedBookV.isEmpty()) {
                bookComboBox.getStyleClass().add("searchBorderGreen");
            } else {
                bookComboBox.getStyleClass().add("searchBorderRed");
                
            }
        }
        
        String bookName = bookComboBox.getValue();
        if (bookName != null) {
            String bookData[] = bookName.split("-");
            int bookId = Integer.parseInt(bookData[0]);
            
            Book selectedBook = getSelectedBook(bookId);
            if (selectedBook != null) {
                book_Id = bookId;
                pageCountTxt.setText(selectedBook.getPageCount());
                copyCountTxt.setText(selectedBook.getCopyCount());
                aoutherTxt.setText(selectedBook.getAuthor());
                titleTxt.setText(selectedBook.getTitle());
                isbnTxt.setText(selectedBook.getIsbn());
                categoryTxt.setText(selectedBook.getCatgeory());
                publishDateTxt.setText(selectedBook.getPublishDate());
                publisherTxt.setText(selectedBook.getPublisher());
                bookImages[0] = new Image(SceneBuilderLibrarySystem.class
                        .getResourceAsStream(selectedBook.getBookImagePath()));
                bookImageViewUser.setImage(bookImages[0]);
                
                String status = checkBorroeBookStatus(userLogin.getId(), bookId);
                
                if (status == null) {
                    borrowButton.setText("Borrow");
                    borrowButton.setStyle("-fx-background-color: #90EE90;");
                    borrowButton.setDisable(false);
                }
                if (status.equals("Pending")) {
                    borrowButton.setText("Pending");
                    borrowButton.setStyle("-fx-background-color: #ffd9f7;");
                    borrowButton.setDisable(true);
                    
                }
                if (status.equals("Approved")) {
                    borrowButton.setText("Approved");
                    borrowButton.setStyle("-fx-background-color: #a0f2ff;");
                    borrowButton.setDisable(true);
                    
                }
                
                if (status.equals("Rejected")) {
                    borrowButton.setText("Reject");
                    borrowButton.setStyle("-fx-background-color: orange;");
                    borrowButton.setDisable(true);
                }
            }
            
        }
    }

    //----------------------------------------------------
    public String checkBorroeBookStatus(int userId, int bookId) {
        String status = null;
        for (BorrowBookDetailes bbd : SceneBuilderLibrarySystem.borrowBooksDetailes) {
            if (bbd.getBookId() == bookId && bbd.getUserId() == userId) {
                status = bbd.getStatus();
                break;
            }
        }
        return status;
    }

    //--------------------------------------
    public Book getBookDetaileds(int bookId) {
        Book sb = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                sb = b;
            }
        }
        return sb;
    }
    //------------------------------------      

    public Book getSelectedBook(int bookId) {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                book = b;
            }
        }
        return book;
    }

    //-------------------------------------------- 
    public void clearInputs() {
        titleTxt.clear();
        aoutherTxt.clear();
        publishDateTxt.clear();
        publisherTxt.clear();
        isbnTxt.clear();
        copyCountTxt.clear();
        pageCountTxt.clear();
        imageBookName = null;
        bookImageViewUser.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/bb.jpg")));
        borrowButton.setStyle("-fx-background-color:#90EE90;");
        categoryComboBox.setValue(null);
        bookComboBox.setValue(null);
        borrowButton.setText("Borrow");
        bookComboBox.getItems().setAll("");
    }
    
    @FXML
    private void LogOutSystem(MouseEvent event) {
        logOut(event);
    }
    
}
