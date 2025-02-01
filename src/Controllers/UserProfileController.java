/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.LoginController.admin;
import Model.User;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.AdminStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.RegisterStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.UserProfileStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.userLogin;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.users;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class UserProfileController implements Initializable {

    @FXML
    private Label phoneNumberLabel;
    @FXML
    private TextField phoneNumberTxt;
    @FXML
    private Label phoneNumberLabelError;
    @FXML
    private Label phoneNumberLabelError1;
    @FXML
    private ComboBox<String> role;
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
    private ImageView profileImageView;
    @FXML
    private Label imageLabelError;
    @FXML
    private Label userImage;
    @FXML
    private Label profileImageViewLabelError;
    private String imageName;
    Image profileImages[] = {null};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (admin != null) {
            fullNameTxt.setText(admin.getFullName());
            usernameTxt.setText(admin.getUserName());
            passwordTxt.setText(admin.getPassword());
            emailTxt.setText(admin.getEmail());
            phoneNumberTxt.setText(admin.getPhoneNumber());
            role.setValue(admin.getRole());
            profileImages[0] = new Image(SceneBuilderLibrarySystem.class.getResourceAsStream(admin.getProfileImagePath()));
            profileImageView.setImage(profileImages[0]);
        }
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
    private void showDashBoard(ActionEvent event) {
        UserProfileStage.close();
        AdminStage.show();
    }

    @FXML
    private void updateInformation(ActionEvent event) {

        if (userLogin != null) {
            boolean sameUserFound = false;
            for (User user : users) {
                if (userLogin.getUserName().equals(usernameTxt.getText())) {
                    continue;
                }

                if (user.getUserName().equals(usernameTxt.getText())) {
                    sameUserFound = true;
                    break;
                }
            }
            if (!sameUserFound) {

                userLogin.setFullName(fullNameTxt.getText());
                userLogin.setUserName(usernameTxt.getText());
                userLogin.setEmail(emailTxt.getText());
                userLogin.setPhoneNumber(phoneNumberTxt.getText());
                if (this.imageName != null) {
                    userLogin.setProfileImagePath(this.imageName);
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Updated");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "User Name used by another Acount");
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

    public void saveImage(Image img, String name) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String imagesFolderPath = projectPath + "/src/images";
        File imageFolder = new File(imagesFolderPath);
        if (!imageFolder.exists()) {
            imageFolder.mkdir();
        }

    }
}
