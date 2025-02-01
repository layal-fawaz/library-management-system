/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.RegisterStage;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class RegisterController implements Initializable {

    @FXML
    private Label phoneNumberLabel;
    @FXML
    private TextField phoneNumberTxt;
    @FXML
    private Label phoneNumberLabelError;
    @FXML
    private Label phoneNumberLabelError1;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField passwordTxt;
    @FXML
    private Label passwordLabelError;
    @FXML
    private Label userNameLabel;
    @FXML
    private TextField usernameTxt;
    @FXML
    private Label usernameLabelError;
    @FXML
    private Label fullNameLabel;
    @FXML
    private TextField fullNameTxt;
    @FXML
    private Label fullNameLabelError;
    @FXML
    private Label emailabel;
    @FXML
    private TextField emailTxt;
    @FXML
    private Label emailLabelError;
    @FXML
    private Label imageLabelError;
    @FXML
    private Label userImage;
    @FXML
    private ImageView profileImageView;
    @FXML
    private Label profileImageViewLabelError;
    @FXML
    private ComboBox<String> role;
    private String imageName;
    @FXML
    private Label roleLabelError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        role.getItems().addAll("Admin", "Libririan", "User");
        role.setValue("User");
        role.setDisable(true);
    }

    @FXML
    private void uploadUserImage(MouseEvent event) {

        //profile images ------------------------
        Image[] profileImages = {null};
        profileImageView.setOnMouseClicked(e -> {
            FileChooser fileCh = new FileChooser();
            File file = fileCh.showOpenDialog(RegisterStage);
            if (file != null) {
                profileImages[0] = new Image(file.toURI().toString());
                profileImageView.setImage(profileImages[0]);
                this.imageName = "/images/" + file.getName();

                try {
                    saveImage(profileImages[0], file.getName());
                } catch (IOException ex) {
                    ex.getStackTrace();
                }
            }
        });

    }

    @FXML
    private void showLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
        Scene RiScene = new Scene(root);
        SceneBuilderLibrarySystem.stageData(SceneBuilderLibrarySystem.LoginStage,
                RiScene, "logo.jpg", "Login Screen", 450, 150);
        SceneBuilderLibrarySystem.LoginStage.show();
        SceneBuilderLibrarySystem.RegisterStage.hide();

    }

    @FXML
    private void register(ActionEvent event) {
        fullNameLabelError.setText("");
        usernameLabelError.setText("");
        passwordLabelError.setText("");
        emailLabelError.setText("");
        roleLabelError.setText("");
        profileImageViewLabelError.setText("");
        boolean hasError = false;

        if (fullNameTxt.getText().isEmpty()) {
            fullNameLabelError.setText("full name is required");
            hasError = true;
        }

        if (usernameTxt.getText().isEmpty()) {
            usernameLabelError.setText("user name is required");
            hasError = true;

        }

        if (passwordTxt.getText().isEmpty()) {
            passwordLabelError.setText("password is required");
            hasError = true;

        }

        if (emailTxt.getText().isEmpty()) {
            emailLabelError.setText("email is required");
            hasError = true;

        }
        if (phoneNumberTxt.getText().isEmpty()) {
            phoneNumberLabelError.setText("phone number is required");
            hasError = true;

        }

        if (this.imageName == null || this.imageName.isEmpty()) {
            profileImageViewLabelError.setText("picture is required");
            hasError = true;

        }
        if (role.getValue().isEmpty()) {
            roleLabelError.setText("role is required");
            hasError = true;

        }

        if (!hasError) {
            boolean isFound = userExist(usernameTxt.getText(), passwordTxt.getText());
            if (!isFound) {

                User newUser = new User(fullNameTxt.getText(), usernameTxt.getText(),
                        passwordTxt.getText(), emailTxt.getText(), phoneNumberTxt.getText(),
                        role.getValue(), this.imageName.toString());

                SceneBuilderLibrarySystem.users.add(newUser);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "user has been register");
                alert.showAndWait();
//clear inputs-------------------
                usernameTxt.clear();
                passwordTxt.clear();
                fullNameTxt.clear();
                emailTxt.clear();
                phoneNumberTxt.clear();
                role.setValue("");
                this.imageName = null;
                SceneBuilderLibrarySystem.LoginStage.show();
                SceneBuilderLibrarySystem.RegisterStage.hide();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "user is already Exist");
                alert.showAndWait();
            }
        }

    }

    public boolean userExist(String userName, String pass) {
        boolean userFound = false;
        for (User user : SceneBuilderLibrarySystem.users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(pass)) {
                userFound = true;
            }
        }
        return userFound;
    }

    //-------------------------------------save image
    public void saveImage(Image img, String name) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String imagesFolderPath = projectPath + "/src/images";
        File imageFolder = new File(imagesFolderPath);
        if (!imageFolder.exists()) {
            imageFolder.mkdir();
        }

    }
}
