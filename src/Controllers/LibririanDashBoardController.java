/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataBase.BookDataBaseHandeler;
import DataBase.BorrowBookDataBaseHandler;
import Model.Book;
import Model.BorrowBook;
import Model.BorrowBookDetailes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LibririanStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LoginStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.allBooksStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.books;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.borrowBooks;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.borrowBooksDetailes;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.userLogin;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class LibririanDashBoardController implements Initializable {

    @FXML
    private Label homeSideBar;
    @FXML
    private AnchorPane homeAnchor;
    @FXML
    private ImageView userProfileImage;
    @FXML
    private Label userProfileLabel;
    @FXML
    private Label borrowBookManagementSideBar;
    @FXML
    private Label StatisticsSideBar;
    @FXML
    private ComboBox<String> statusComboBox;
    @FXML
    private TableColumn<BorrowBookDetailes, Integer> userIdColoumn;
    @FXML
    private TableColumn<BorrowBookDetailes, Integer> userNameColoumn;
    @FXML
    private TableColumn<BorrowBookDetailes, ImageView> userImageColoumn;
    @FXML
    private TableColumn<BorrowBookDetailes, String> bookIdColumn;
    @FXML
    private TableColumn<BorrowBookDetailes, String> bookTitleColumn;
    @FXML
    private TableColumn<BorrowBookDetailes, ImageView> bookImageColumn;
    @FXML
    private TableColumn<BorrowBookDetailes, String> borrowStatusColumn;
    @FXML
    private TableColumn<BorrowBookDetailes, Button> actionColumn;
    @FXML
    private AnchorPane BorrowBookAnchor;
    @FXML
    private AnchorPane statisticsAnchor;
    @FXML
    private TableView<BorrowBookDetailes> borrowBookTabelView;
    @FXML
    private Label allBooks;
    @FXML
    private Label borrowdNum;
    @FXML
    private Label pendingBooks;
    @FXML
    private Label approvedBooks;
    @FXML
    private ImageView borrowImage;
    @FXML
    private ImageView pendingImage;
    @FXML
    private ImageView approvedImage;
    @FXML
    private ImageView allB;

    public void initialize(URL url, ResourceBundle rb) {
        homeSideBar.getStyleClass().add("sideBarLabel");
        borrowBookManagementSideBar.getStyleClass().add("sideBarLabel");
        StatisticsSideBar.getStyleClass().add("sideBarLabel");
        setSelectedSideBar(homeSideBar, homeAnchor);

        statusComboBox.getItems().addAll("All", "Approved", "Rejected", "Pending");
        //--------------------imageView
        userProfileImage.setImage(new Image(userLogin.getProfileImagePath()));
        userProfileLabel.setText(userLogin.getFullName());

        userIdColoumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        userNameColoumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userImageColoumn.setCellValueFactory(new PropertyValueFactory<>("userImage"));
        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        bookImageColumn.setCellValueFactory(new PropertyValueFactory<>("bookImage"));

        bookImageColumn.setCellValueFactory(cellData -> {
            ImageView bookImage = new ImageView(cellData.getValue().getBookImage());
            bookImage.setFitHeight(40);
            bookImage.setFitWidth(40);
            return new SimpleObjectProperty<>(bookImage);
        });

        userImageColoumn.setCellValueFactory(cellData -> {
            ImageView userImage = new ImageView(cellData.getValue().getUserImage());
            userImage.setFitHeight(40);
            userImage.setFitWidth(40);
            return new SimpleObjectProperty<>(userImage);
        });

        borrowStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        borrowStatusColumn.setCellFactory(param -> new TableCell<BorrowBookDetailes, String>() {
            @Override
            protected void updateItem(String status, boolean empty) {
                super.updateItem(status, empty);

                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Button statusButton = new Button(status);
                    if (status != null) {
                        if (status.equals("Pending")) {
                            statusButton.setStyle("-fx-background-color: orange;");

                        } else if (status.equals("Approved")) {
                            statusButton.getStyleClass().add("approved");
                        } else if (status.equals("Rejected")) {
                            statusButton.getStyleClass().add("reject");
                        }
                    }
                    setText(null);
                    setGraphic(statusButton);
                }
            }
        });

        actionColumn.setCellFactory(param -> new TableCell<BorrowBookDetailes, Button>() {
            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || getTableRow().getItem() == null) {
                    setGraphic(null);
                } else {
                    Button actionButtonA = new Button("Approve");
                    Button actionButtonR = new Button("Reject");

                    actionButtonA.getStyleClass().add("approved");
                    actionButtonR.getStyleClass().add("reject");

                    BorrowBookDetailes currentBr = (BorrowBookDetailes) getTableRow().getItem();

                    if (currentBr.getStatus().equals("Approved")) {
                        actionButtonA.setText("Approved Book");
                        actionButtonR.setVisible(false);
                        actionButtonA.getStyleClass().add("actionButtonA");
                            bookCount();

                    } else if (currentBr.getStatus().equals("Rejected")) {
                        actionButtonR.setText("Rejected Book");
                        BorrowBookDataBaseHandler.updateStatus(currentBr.getUserId(), currentBr.getBookId(), currentBr.getStatus());

                        actionButtonA.setVisible(false);
                        actionButtonR.getStyleClass().add("actionButtonR");
                        bookCount();
                    }

                    actionButtonA.setOnAction(event -> {
                        if (currentBr != null) {
                            currentBr.setStatus("Approved");
                            actionButtonA.setText("Approved Book");
                            actionButtonR.setVisible(false);
                            BorrowBookDataBaseHandler.updateStatus(currentBr.getUserId(), currentBr.getBookId(), currentBr.getStatus());
                            for (Book book : books) {
                                if (book.getId() == (currentBr.getBookId())) {
                                    int copy = Integer.parseInt(book.getCopyCount()) - 1;
                                    if (copy >= 0) {
                                        book.setCopyCount(String.valueOf(copy));
                                        BookDataBaseHandeler.updateBook(book);
                                                                    bookCount();

                                        if (copy == 0) {
                                            actionButtonA.setVisible(false);
                                        }
                                        break;
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.ERROR, "No enough copies");
                                        alert.showAndWait();
                                        currentBr.setStatus("Rejected");
                                        actionButtonR.setText("Rejected Book");
                                        actionButtonA.setVisible(false);
                                    }
                                }
                            }
                            getTableView().refresh();
                            
                        }
                    });

                    actionButtonR.setOnAction(event -> {
                        if (currentBr != null) {
                            currentBr.setStatus("Rejected");
                            actionButtonR.setText("Rejected Book");
                            actionButtonA.setVisible(false);
                            getTableView().refresh();
                            bookCount();
                        }
                    });

                    setGraphic(new HBox(10, actionButtonA, actionButtonR));
                }
            }
        });

        borrowBookTabelView.setItems(borrowBooksDetailes);
        bookCount();

    }

    public void bookCount() {
        allBooks.setText(books.size() + "");

        int pendNum = (int) borrowBooksDetailes.stream().filter(u -> u.getStatus().equals("Pending")).count();
        pendingBooks.setText(pendNum + "");

        int apprNum = (int) borrowBooksDetailes.stream().filter(u -> u.getStatus().equals("Approved")).count();
        approvedBooks.setText(apprNum + "");

        borrowdNum.setText(pendNum + apprNum + "");
    }

    @FXML
    private void showHomeSidebar(MouseEvent event) {
        setSelectedSideBar(homeSideBar, homeAnchor);
    }

    @FXML
    private void showUserManagementSideBar(MouseEvent event) {
        setSelectedSideBar(borrowBookManagementSideBar, BorrowBookAnchor);

    }

    @FXML
    private void showBookManagementSideBar(MouseEvent event) {
        setSelectedSideBar(StatisticsSideBar, statisticsAnchor);

    }

    public void setSelectedSideBar(Label selectedLabel, AnchorPane anchor) {
        homeSideBar.getStyleClass().remove("selected");
        borrowBookManagementSideBar.getStyleClass().remove("selected");
        StatisticsSideBar.getStyleClass().remove("selected");
        selectedLabel.getStyleClass().add("selected");

        //------------------
        homeAnchor.setVisible(false);
        statisticsAnchor.setVisible(false);
        BorrowBookAnchor.setVisible(false);

        anchor.setVisible(true);
    }

    @FXML
    private void logOut(MouseEvent event) {
        LibririanStage.close();
        LoginStage.show();
    }
private String selectedStatus = "All";

@FXML
private void selsectStatus(ActionEvent event) {
    selectedStatus = statusComboBox.getValue();

    if (selectedStatus == null || selectedStatus.equals("All")) {
        borrowBookTabelView.setItems(borrowBooksDetailes);
    } else {
        ObservableList<BorrowBookDetailes> filteredStatus = FXCollections.observableArrayList();

        for (BorrowBookDetailes item : borrowBooksDetailes) {
            if (item.getStatus().equals(selectedStatus)) {
                filteredStatus.add(item);
            }
        }

        borrowBookTabelView.setItems(filteredStatus);
    }
}


@FXML
private void showBorrowBookStatistic(MouseEvent event) throws IOException {
    String selectedBook = "";
    if (event.getSource() == borrowImage) {
        selectedBook = "Borrowed"; 
    } else if (event.getSource() == pendingImage) {
        selectedBook = "Pending";
    } else if (event.getSource() == approvedImage) {
        selectedBook = "Approved"; 
    }

    ObservableList<BorrowBookDetailes> filteredBooks = FXCollections.observableArrayList();

    for (BorrowBookDetailes b : borrowBooksDetailes) {
        if (selectedBook.equals("Borrowed")) {
            if ("Pending".equals(b.getStatus()) || "Approved".equals(b.getStatus())) {
                filteredBooks.add(b); 
            }
        } else if (selectedBook.equals(b.getStatus())) {
            filteredBooks.add(b);
        }
    }


    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/BookStatistic.fxml"));
    Parent root = loader.load();

    BookStatistic bookStat = loader.getController();
    bookStat.setSelectedStatus(selectedBook);
    bookStat.setTableBookData(filteredBooks);

    Scene RiScene = new Scene(root);
    SceneBuilderLibrarySystem.stageData(SceneBuilderLibrarySystem.bookStatistic,
            RiScene, "images.png", "bookStatistic", 300, 60);
    SceneBuilderLibrarySystem.bookStatistic.show();
    SceneBuilderLibrarySystem.LibririanStage.hide();
}

    @FXML
    private void LogOutSystem(MouseEvent event) {
        logOut(event);
    }

    @FXML
    private void showBooks(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Books.fxml"));
        Scene allBooksS = new Scene(root);
        SceneBuilderLibrarySystem.stageData(allBooksStage, allBooksS, "images (3).jpg", "allBooks in systum", 300, 60);
        LibririanStage.close();
        allBooksStage.show();
    }

}
