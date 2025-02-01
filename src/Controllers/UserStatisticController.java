/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.User;
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
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.AdminStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.UserStatistic;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.users;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class UserStatisticController implements Initializable {
    @FXML
    private TextField userFilter;  
    @FXML
    private TableView<User> statisticTableView;  
    @FXML
    private TableColumn<User, String> fullName;  
    @FXML
    private TableColumn<User, String> role;  
    @FXML
    private TableColumn<User, String> username;  
    @FXML
    private TableColumn<User, String> password;  
    @FXML
    private TableColumn<User, String> email;  
    @FXML
    private TableColumn<User, String> phone;  
    @FXML
    private TableColumn<User, ImageView> userImage;  
    private ObservableList<User> users = FXCollections.observableArrayList(); 
    private String filterClear = ""; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        username.setCellValueFactory(new PropertyValueFactory<>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));

        userImage.setCellValueFactory(cellData -> {
            String profileImagePath = cellData.getValue().getProfileImagePath();
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

        statisticTableView.setItems(users);

        userFilter.textProperty().addListener(((observable, oldValue, newValue) -> {
            filterClear = newValue;
            filterTable(newValue);
        }));
    }

    public void setTableData(ObservableList<User> users) {
        this.users = users;
        statisticTableView.setItems(users);
    }

    public void filterTable(String contain) {
        ObservableList<User> searchUsers = FXCollections.observableArrayList();

        for (User u : users) {
            if (u.getFullName().toLowerCase().contains(contain)
                    || u.getUserName().toLowerCase().contains(contain.toLowerCase())
                    || u.getEmail().toLowerCase().contains(contain.toLowerCase())
                    || u.getPhoneNumber().toLowerCase().contains(contain.toLowerCase())
                    || u.getPassword().toLowerCase().contains(contain.toLowerCase())
                    || u.getRole().toUpperCase().contains(contain.toLowerCase())) {
                searchUsers.add(u);
            }
        }

        statisticTableView.setItems(searchUsers);
    }

    @FXML
    private void clear(ActionEvent event) {
        userFilter.clear();
        filterTable(filterClear);    
    }

    @FXML
    private void filterByRole(String role) {
        filterClear = role;
        filterTable(userFilter.getText());
    }

    @FXML
    private void filterAdmin(ActionEvent event) {
        filterByRole("Admin");
    }

    @FXML
    private void filterLibrarian(ActionEvent event) {
        filterByRole("Libraran");
    }

    @FXML
    private void filterUser(ActionEvent event) {
        filterByRole("User");
    }

    @FXML
    private void logOut(MouseEvent event) {
        UserStatistic.hide();
        AdminStage.show();
    }
}


