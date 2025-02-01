/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.Book;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.AdminStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LibririanStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LoginStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.UserStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.stageData;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class LoginController implements Initializable {

    @FXML
    private Button RegisterButton;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView loginImageView;

    @FXML
    private Label loginLabel;

    @FXML
    private Label passwordLabelError;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Label userNameLabelError;

    @FXML
    private TextField userNameTxt;

    @FXML
    private Label passwordLabel;

    public static User admin;
    @FXML
    private Label userNameLabel;

    @FXML
    void loginUser(ActionEvent event) throws IOException {

        String userName = userNameTxt.getText().trim();
        String password = passwordTxt.getText().trim();

        userNameLabelError.setText("");
        passwordLabelError.setText("");
        User user = ValidateUser(userName, password);

        if (user == null) {
            if (userName.isEmpty()) {
                userNameLabelError.setText("UserName is Required");
            } else if (password.isEmpty()) {
                passwordLabelError.setText("Password is Required");
            } else {
                userNameLabelError.setText("Invalid UserName or Password");
            }
        } else {

            SceneBuilderLibrarySystem.userLogin = user;
            if (user.getRole().equals("Admin")) {
                switchScene(AdminStage, "/Views/Admin.fxml", "Admin Dashboard", "image.png");
            } else if (user.getRole().equals("Libriran")) {

                switchScene(LibririanStage, "/Views/LibririanDashBoard.fxml", "Librarian Dashboard", "images (2).jpg");
            } else if (user.getRole().equals("User")) {

                switchScene(UserStage, "/Views/UserDashBoard.fxml", "User Dashboard", "images (2).jpg");
            }
        }
    }

    @FXML
    void showRegisterPage(ActionEvent event) throws IOException {

        SceneBuilderLibrarySystem.LoginStage.hide();
        switchScene(SceneBuilderLibrarySystem.RegisterStage, "/Views/Register.fxml", "Register Screen", "image.png");
    }

    //helper functions --------------------------
    public User ValidateUser(String userName, String password) {
        for (User user : SceneBuilderLibrarySystem.users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void switchScene(Stage stage, String fxmlPath, String title, String iconName) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        SceneBuilderLibrarySystem.setStageImageIcon(stage, iconName);

        stage.show();
        SceneBuilderLibrarySystem.LoginStage.hide();

    }

}
