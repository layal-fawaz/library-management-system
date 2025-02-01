/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataBase.BookDataBaseHandeler;
import DataBase.UserDataBaseHandeler;
import Model.Book;
import Model.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.AdminStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.CategoryStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LoginStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.UserProfileStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.books;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.categories;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.setStageImageIcon;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.userLogin;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.users;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class AdminController implements Initializable {

    @FXML
    private Label SidebareHome;
    @FXML
    private Label SidebareUserManagments;
    @FXML
    private Label SidebareBookManagments;
    @FXML
    private AnchorPane AnchorPaneHome;
    @FXML
    private AnchorPane AnchorPaneUserManagments;
    @FXML
    private AnchorPane AnchorPaneBookManagments;
    @FXML
    private ImageView UserProfileImage;
    @FXML
    private Label UserProfileFullName;
    @FXML
    private ComboBox<String> userRoleComboBox;
    @FXML
    private TableView<User> tableViewUser;
    @FXML
    private TableColumn<User, String> fullNameColumn;
    @FXML
    private TableColumn<User, String> roleColumn;
    @FXML
    private TableColumn<User, String> userNameColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> phoneColumn;
    @FXML
    private TableColumn<User, ImageView> UserImageColumn;
    @FXML
    private Label profilePictureLabelError;
    @FXML
    private TextField fullNameTf;
    @FXML
    private Label fullNameLabelError;
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private Label roleLabelError;
    @FXML
    private TextField userNameTf;
    @FXML
    private Label userNameLabelError;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private Label passwordLabelError;
    @FXML
    private TextField emailTf;
    @FXML
    private Label emailLabelError;
    @FXML
    private TextField phoneTf;
    @FXML
    private Label phoneLabelError;
    public String imageName = null;
    @FXML
    private ImageView UserProfileImagemid;
    @FXML
    private ComboBox<String> BookFilter;
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
    @FXML
    private ImageView formBookImage;
    @FXML
    private Label formBookImageLabelError;
    @FXML
    private ComboBox<String> formCategoryComboBox;
    @FXML
    private Label formCategoryComboBoxLabelError;
    @FXML
    private ComboBox<String> languagesComboBox;
    @FXML
    private Label languagesComboBoxLabelError;
    @FXML
    private TextField titleTf1;
    @FXML
    private Label titleLabelError1;
    @FXML
    private TextField authorTf;
    @FXML
    private Label authorLabelError;
    @FXML
    private TextField isbanTf;
    @FXML
    private Label isbanLabelError;
    @FXML
    private TextField publishDateTf;
    @FXML
    private Label publishDateLabelError;
    @FXML
    private TextField pageCountTf;
    @FXML
    private Label pageCountLabelError;
    @FXML
    private TextField copyCountTf;
    @FXML
    private Label copyCountLabelError;
    @FXML
    private TextField publisherTf;
    @FXML
    private Label publisherLabelError;
    Image[] profileImage = {null};
    static Image[] bookImage = {null};
    static String bookImageName = null;
    @FXML
    private AnchorPane AnchorPaneStatistic;
    @FXML
    private Label SideBarStatistic;
    @FXML
    private Label adminNumbers;
    @FXML
    private Label libririanNumbers;
    @FXML
    private Label userNumbers;
    @FXML
    private Label allUsersNumber;
    @FXML
    private ImageView all;
    @FXML
    private ImageView adminImage;
    @FXML
    private ImageView librarianImage;
    @FXML
    private ImageView userImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        SidebareHome.getStyleClass().add("sidebare_label");
        SidebareUserManagments.getStyleClass().add("sidebare_label");
        SidebareBookManagments.getStyleClass().add("sidebare_label");
        SideBarStatistic.getStyleClass().add("sidebare_label");
        SetSelectedSidebar(SidebareHome, AnchorPaneHome);
        usersCount();

        UserProfileFullName.setText(userLogin.getFullName());
        UserProfileImage.setImage(new Image(userLogin.getProfileImagePath()));

        UserProfileImage.imageProperty().bind(
                Bindings.createObjectBinding(() -> new Image(userLogin.getProfileImagePath()), userLogin.ProfileImagePathProperty())
        );
        UserProfileFullName.textProperty().bind(userLogin.fullNameProperty());
        //-----------------set Role data
        roleComboBox.getItems().addAll("User", "Libriran", "Admin");
        roleComboBox.setValue("User");
        userRoleComboBox.getItems().addAll("All", "User", "Libriran", "Admin");

        //--------------------set cell data usertable
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        UserImageColumn.setCellValueFactory(cellData -> {
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

            userImage.setFitHeight(50);
            userImage.setFitWidth(50);
            return new SimpleObjectProperty<>(userImage);
        });

        tableViewUser.setItems(users);

        //----------------------------set book comboBox------------------------
        languagesComboBox.getItems().addAll("Eng", "AR");

        categories.addAll("Languages", "Coding", "Novels");
        formCategoryComboBox.setItems(categories);
        ObservableList<String> filteredCategories = FXCollections.observableArrayList();
        filteredCategories.addAll(categories);
        filteredCategories.add(0, "All");
        BookFilter.setItems(filteredCategories);

        categories.addListener((ListChangeListener<String>) change -> {
            filteredCategories.setAll(categories);
            filteredCategories.add(0, "All");
            BookFilter.setItems(filteredCategories);
        });

        BookFilter.setOnAction(e -> {
            String selectedCategeory = BookFilter.getValue();
            ObservableList<Book> filteredCategeory = FXCollections.observableArrayList();
            if (selectedCategeory != null) {
                if (selectedCategeory.equals("All")) {
                    filteredCategeory.addAll(books);
                } else {
                    for (Book book : books) {
                        if (selectedCategeory.equals(book.getCatgeory())) {
                            filteredCategeory.add(book);
                        }
                    }
                }
            }

            tableViewBook.setItems(filteredCategeory);

        });

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

            userImage.setFitHeight(60);
            userImage.setFitWidth(60);
            return new SimpleObjectProperty<>(userImage);
        });

        tableViewBook.setItems(books);
    }

    public void usersCount() {
        allUsersNumber.setText(users.size() + "");

        allUsersNumber.setText(users.size() + "");
        int admNum = (int) users.stream().filter(u -> u.getRole().equals("Admin")).count();
        adminNumbers.setText(admNum + "");

        int libNum = (int) users.stream().filter(u -> u.getRole().equals("Libriran")).count();
        adminNumbers.setText(admNum + "");
        libririanNumbers.setText(libNum + "");

        int userNum = (int) users.stream().filter(u -> u.getRole().equals("User")).count();
        userNumbers.setText(userNum + "");
    }

    @FXML
    private void ShowSidebareHome(MouseEvent event) {
        SetSelectedSidebar(SidebareHome, AnchorPaneHome);
    }

    @FXML
    private void ShowSidebareUserManagments(MouseEvent event) {
        SetSelectedSidebar(SidebareUserManagments, AnchorPaneUserManagments);

    }

    @FXML
    private void ShowSidebareBookManagments(MouseEvent event) {
        SetSelectedSidebar(SidebareBookManagments, AnchorPaneBookManagments);

    }

    public void SetSelectedSidebar(Label selectedLabel, AnchorPane selectedAnchorPane) {
        SidebareHome.getStyleClass().remove("selected");
        SidebareUserManagments.getStyleClass().remove("selected");
        SidebareBookManagments.getStyleClass().remove("selected");
        SideBarStatistic.getStyleClass().remove("selected");
        selectedLabel.getStyleClass().add("selected");
        //------------------------------------------------------------
        AnchorPaneHome.setVisible(false);
        AnchorPaneUserManagments.setVisible(false);
        AnchorPaneBookManagments.setVisible(false);
        AnchorPaneStatistic.setVisible(false);
        selectedAnchorPane.setVisible(true);

    }

    @FXML
    private void LogOut(MouseEvent event) {
        AdminStage.close();
        LoginStage.show();
    }

    @FXML
    private void UplodeUserImageProfile(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(AdminStage);
        if (file != null) {
            profileImage[0] = new Image(file.toURI().toString());
            UserProfileImagemid.setImage(profileImage[0]);
            //to save image
            this.imageName = "/images/" + file.getName();
            try {
                saveImage(profileImage[0], file.getName());
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }

    }

    @FXML
    private void addUser(ActionEvent event) {

        fullNameLabelError.setText("");
        userNameLabelError.setText("");
        passwordLabelError.setText("");
        emailLabelError.setText("");
        phoneLabelError.setText("");
        profilePictureLabelError.setText("");
        roleLabelError.setText("");

        boolean hasError = false;
        if (fullNameTf.getText().isEmpty()) {
            fullNameLabelError.setText("fullName is required.");
            hasError = true;
        }
        if (userNameTf.getText().isEmpty()) {
            userNameLabelError.setText("UserName is required.");
            hasError = true;
        }
        if (passwordTf.getText().isEmpty()) {
            passwordLabelError.setText("Password is required.");
            hasError = true;
        }
        if (emailTf.getText().isEmpty()) {
            emailLabelError.setText("Email is required.");
            hasError = true;
        }
        if (phoneTf.getText().isEmpty()) {
            phoneLabelError.setText("Phone is required.");
            hasError = true;
        }
        if (this.imageName == null) {
            profilePictureLabelError.setText("Image is required.");
            hasError = true;
        }

        if (!hasError) {
            boolean isFoundUser = UserExiest(userNameTf.getText(), passwordTf.getText());
            if (!isFoundUser) {
                User newUser = new User(fullNameTf.getText(), userNameTf.getText(), passwordTf.getText(), emailTf.getText(), phoneTf.getText(), roleComboBox.getValue(), this.imageName.toString());
                users.add(newUser);
                UserDataBaseHandeler.addUser(newUser);

                //-----------alert
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "User has Been added ...");
                alert.showAndWait();
                usersCount();
                //        -----------clear input
                fullNameTf.clear();
                userNameTf.clear();
                passwordTf.clear();
                emailTf.clear();
                phoneTf.clear();
                this.imageName = null;
                UserProfileImagemid.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/images.png")));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "user is already exist");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void daleteUser(ActionEvent event) {

        User selectedUser = tableViewUser.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            for (User user : users) {
                if (user.getUserName().equals(selectedUser.getUserName())) {
                    users.remove(user);
                    UserDataBaseHandeler.deleteUser(user);
                    usersCount();

                    fullNameTf.clear();
                    userNameTf.clear();
                    passwordTf.clear();
                    phoneTf.clear();
                    emailTf.clear();
                    this.imageName = null;
                    UserProfileImagemid.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/images.png")));
                    if (selectedUser.equals(userLogin)) {
                        AdminStage.close();
                        LoginStage.show();
                    }
                    break;
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please Select User To Delete..");
            alert.showAndWait();
        }
    }

    @FXML
    private void updateUser(ActionEvent event) {
        User selectedUser = tableViewUser.getSelectionModel().getSelectedItem();
        boolean sameUserAuth = false;
        int userIndex = 0;
        if (selectedUser != null) {

            fullNameLabelError.setText("");
            userNameLabelError.setText("");
            passwordLabelError.setText("");
            emailLabelError.setText("");
            phoneLabelError.setText("");
            profilePictureLabelError.setText("");
            roleLabelError.setText("");

            boolean hasError = false;
            if (fullNameTf.getText().isEmpty()) {
                fullNameLabelError.setText("fullName is required.");
                hasError = true;
            }
            if (userNameTf.getText().isEmpty()) {
                userNameLabelError.setText("UserName is required.");
                hasError = true;
            }
            if (passwordTf.getText().isEmpty()) {
                passwordLabelError.setText("Password is required.");
                hasError = true;
            }
            if (emailTf.getText().isEmpty()) {
                emailLabelError.setText("Email is required.");
                hasError = true;
            }
            if (phoneTf.getText().isEmpty()) {
                phoneLabelError.setText("Phone is required.");
                hasError = true;
            }

            if (!hasError) {
                for (User user : users) {
                    if (user.getUserName().equals(selectedUser.getUserName())) {
                        selectedUser = user;
                        userIndex = users.indexOf(user);
                        if (users.indexOf(user) == users.indexOf(userLogin)) {
                            sameUserAuth = true;
                        }
                        break;
                    }
                }
                boolean sameUserFound = false;
                for (User user : users) {
                    if (selectedUser.getUserName().equals(userNameTf.getText())) {
                        continue;
                    }
                    if (user.getUserName().equals(userNameTf.getText())) {
                        sameUserFound = true;
                        break;

                    }
                }

                if (selectedUser != null) {
                    if (!sameUserFound) {
                        selectedUser.setFullName(fullNameTf.getText());
                        selectedUser.setUserName(userNameTf.getText());
                        selectedUser.setPassword(passwordTf.getText());
                        selectedUser.setEmail(emailTf.getText());
                        selectedUser.setPhoneNumber(phoneTf.getText());
                        selectedUser.setRole(roleComboBox.getValue());
                        if (this.imageName != null) {
                            selectedUser.setProfileImagePath(this.imageName);
                        }
                        users.set(userIndex, selectedUser);
                        UserDataBaseHandeler.updateUser(selectedUser);

                        RefreshUserProfileDataSidebar(sameUserAuth);
                        tableViewUser.setItems(users);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Updated");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, " User Name Is Used By another acount");
                        alert.showAndWait();
                    }

                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please Select User To Update..");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelUser(ActionEvent event) {
        fullNameLabelError.setText("");
        userNameLabelError.setText("");
        passwordLabelError.setText("");
        emailLabelError.setText("");
        phoneLabelError.setText("");
        profilePictureLabelError.setText("");
        roleLabelError.setText("");

        fullNameTf.clear();
        userNameTf.clear();
        passwordTf.clear();
        phoneTf.clear();
        emailTf.clear();
        this.imageName = null;
        UserProfileImagemid.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/images.png")));
    }

    @FXML
    private void SetSelectedUserToForm(MouseEvent event) {
        User user = tableViewUser.getSelectionModel().getSelectedItem();
        if (user != null) {
            fullNameTf.setText(user.getFullName());
            userNameTf.setText(user.getUserName());
            passwordTf.setText(user.getPassword());
            emailTf.setText(user.getEmail());
            phoneTf.setText(user.getPhoneNumber());
            roleComboBox.setValue(user.getRole());

            profileImage[0] = new Image(SceneBuilderLibrarySystem.class.getResourceAsStream(user.getProfileImagePath()));
            UserProfileImagemid.setImage(profileImage[0]);
        }
    }

    @FXML
    private void SetUserRoleFilterTableData(ActionEvent event) {
        String Role = userRoleComboBox.getValue();
        ObservableList<User> FilterUsers = FXCollections.observableArrayList();
        FilterUsers.clear();
        for (User user : users) {
            if (Role.equals("All")) {
                FilterUsers.add(user);
                continue;
            }
            if (user.getRole().equals(Role)) {
                FilterUsers.add(user);
            }
        }
        tableViewUser.setItems(FilterUsers);
    }

    public void RefreshUserProfileDataSidebar(boolean sameUserAuth) {
        if (sameUserAuth) {
            UserProfileImage.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream(userLogin.getProfileImagePath())));
            UserProfileImage.setFitWidth(70);
            UserProfileImage.setFitHeight(70);
            UserProfileFullName.setText(userLogin.getFullName());
        }
    }

    @FXML
    private void ShowUserProfileStage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/UserProfile.fxml"));
        Scene UserProfileScene = new Scene(root);
        stageData(UserProfileStage, UserProfileScene, "logo.jpg", "UserProfile Screen", 450, 150);
        AdminStage.close();
        UserProfileStage.show();

    }

    @FXML
    private void SetBookCategoryFilterTableData(ActionEvent event) {
        String selectedCategory = BookFilter.getValue();
        ObservableList<Book> filteredBooks = FXCollections.observableArrayList();
        if (selectedCategory.equals("All")) {
            tableViewBook.setItems(books);
        } else {

            for (Book book : books) {
                if (book.getCatgeory().equals(selectedCategory)) {
                    filteredBooks.add(book);
                }
            }

            tableViewBook.setItems(filteredBooks);
        }

    }

    @FXML
    private void ShowAddCategoryStage(MouseEvent event) throws IOException {
// 
//        
    }

    @FXML
    private void UplodeformBookImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(AdminStage);
        if (file != null) {
            bookImage[0] = new Image(file.toURI().toString());
            formBookImage.setImage(bookImage[0]);
            this.bookImageName = "/images/" + file.getName();
            try {
                saveImage(bookImage[0], file.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void addBook(ActionEvent event) {
        formBookImageLabelError.setText("");
        formCategoryComboBoxLabelError.setText("");
        languagesComboBoxLabelError.setText("");
        titleLabelError1.setText("");
        authorLabelError.setText("");
        isbanLabelError.setText("");
        publishDateLabelError.setText("");
        pageCountLabelError.setText("");
        copyCountLabelError.setText("");
        publisherLabelError.setText("");

        boolean hasError = false;
        if (bookImageName == null) {
            formBookImageLabelError.setText("Image is required.");
            hasError = true;
        }
        if (formCategoryComboBox.getValue() == null || formCategoryComboBox.getValue().isEmpty()) {
            formCategoryComboBoxLabelError.setText("Category is required.");
            hasError = true;
        }
        if (languagesComboBox.getValue() == null || languagesComboBox.getValue().isEmpty()) {
            languagesComboBoxLabelError.setText("Languages is required.");
            hasError = true;
        }
        if (titleTf1.getText().isEmpty()) {
            titleLabelError1.setText("Title is required.");
            hasError = true;
        }
        if (authorTf.getText().isEmpty()) {
            authorLabelError.setText("Author is required.");
            hasError = true;
        }
        if (isbanTf.getText().isEmpty()) {
            isbanLabelError.setText("Isban is required.");
            hasError = true;
        }
        if (publisherTf.getText().isEmpty()) {
            publisherLabelError.setText("Publisher is required.");
            hasError = true;
        }
        if (publishDateTf.getText().isEmpty()) {
            publishDateLabelError.setText("Publish date is required.");
            hasError = true;
        }

        if (!hasError) {
            if (bookExist(isbanTf.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Book is already exist");
                alert.showAndWait();
            } else {
                Book newBook = new Book(
                        titleTf1.getText(),
                        authorTf.getText(),
                        isbanTf.getText(),
                        publishDateTf.getText(),
                        pageCountTf.getText(),
                        copyCountTf.getText(),
                        publisherTf.getText(),
                        this.bookImageName.toString(),
                        formCategoryComboBox.getValue(),
                        languagesComboBox.getValue()
                );

                if (isNumeric(copyCountTf.getText(), pageCountTf.getText())) {

                    books.add(newBook);
                    BookDataBaseHandeler.addBook(newBook);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book added");
                    alert.showAndWait();
                    tableViewBook.setItems(books);

                    titleTf1.clear();
                    authorTf.clear();
                    pageCountTf.clear();
                    copyCountTf.clear();
                    publishDateTf.clear();
                    isbanTf.clear();
                    publisherTf.clear();
                    languagesComboBox.setValue("");
                    formCategoryComboBox.setValue("");
                    this.bookImageName = null;
                    formBookImage.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/book.jpg")));
                }
            }
        }
    }

    @FXML
    private void deleteBook(ActionEvent event) {
        Book selectedBook = tableViewBook.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            for (Book book : books) {
                if (book.getIsbn().equals(selectedBook.getIsbn())) {
                    books.remove(book);
                    BookDataBaseHandeler.deleteBook(book);
                    titleTf1.clear();
                    authorTf.clear();
                    pageCountTf.clear();
                    copyCountTf.clear();
                    publishDateTf.clear();
                    isbanTf.clear();
                    publisherTf.clear();
                    languagesComboBox.setValue("");
                    formCategoryComboBox.setValue("");
                    this.bookImageName = null;
                    formBookImage.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/book.jpg")));
                    break;
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please Select Book To Delete..");
            alert.showAndWait();
        }
    }

    @FXML
    private void updateBook(ActionEvent event) {
        formBookImageLabelError.setText("");
        formCategoryComboBoxLabelError.setText("");
        languagesComboBoxLabelError.setText("");
        titleLabelError1.setText("");
        authorLabelError.setText("");
        isbanLabelError.setText("");
        publishDateLabelError.setText("");
        pageCountLabelError.setText("");
        copyCountLabelError.setText("");
        publisherLabelError.setText("");

        boolean hasError = false;
        if (formCategoryComboBox.getValue() == null || formCategoryComboBox.getValue().isEmpty()) {
            formCategoryComboBoxLabelError.setText("Category is required.");
            hasError = true;
        }
        if (languagesComboBox.getValue() == null || languagesComboBox.getValue().isEmpty()) {
            languagesComboBoxLabelError.setText("Languages is required.");
            hasError = true;
        }
        if (titleTf1.getText().isEmpty()) {
            titleLabelError1.setText("Title is required.");
            hasError = true;
        }
        if (authorTf.getText().isEmpty()) {
            authorLabelError.setText("Author is required.");
            hasError = true;
        }
        if (isbanTf.getText().isEmpty()) {
            isbanLabelError.setText("Isban is required.");
            hasError = true;
        }
        if (publisherTf.getText().isEmpty()) {
            publisherLabelError.setText("Publisher is required.");
            hasError = true;
        }
        if (publishDateTf.getText().isEmpty()) {
            publishDateLabelError.setText("Publish date is required.");
            hasError = true;
        }
        try {
            int pageCount = Integer.parseInt(pageCountTf.getText());
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "page count must be a number");
            alert.showAndWait();
            hasError = true;
        }

        try {
            int copyCount = Integer.parseInt(copyCountTf.getText());
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Copy count must be a number");
            alert.showAndWait();
            hasError = true;
        }

        if (!hasError) {
            Book selectedBook = tableViewBook.getSelectionModel().getSelectedItem();
            int bookIndex = 0;
            if (selectedBook != null) {
                for (Book book : books) {
                    if (book.getIsbn().equals(selectedBook.getIsbn())) {
                        selectedBook = book;
                        bookIndex = books.indexOf(book);
                        break;
                    }
                }
                boolean sameBookFound = false;
                for (Book book : books) {
                    if (selectedBook.getIsbn().equals(book.getIsbn())) {
                        continue;
                    }
                    if (book.getIsbn().equals(isbanTf.getText())) {
                        sameBookFound = true;
                        break;
                    }
                }
                if (selectedBook != null) {
                    if (!sameBookFound) {
                        selectedBook.setTitle(titleTf1.getText());
                        selectedBook.setAuthor(authorTf.getText());
                        selectedBook.setPageCount(pageCountTf.getText());
                        selectedBook.setCopyCount(copyCountTf.getText());
                        selectedBook.setPublishDate(publishDateTf.getText());
                        selectedBook.setIsbn(isbanTf.getText());
                        selectedBook.setPublisher(publisherTf.getText());
                        selectedBook.setLanguage(languagesComboBox.getValue());
                        selectedBook.setCatgeory(formCategoryComboBox.getValue());

                        if (this.bookImageName != null) {
                            selectedBook.setBookImagePath(this.bookImageName);
                        }
                        books.set(bookIndex, selectedBook);
                        BookDataBaseHandeler.updateBook(selectedBook);
                        tableViewBook.setItems(books);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Updated successfully.");
                        alert.showAndWait();
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a book to update.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void SetSelectedBookToForm(MouseEvent event) {
        Book book = tableViewBook.getSelectionModel().getSelectedItem();
        if (book != null) {
            titleTf1.setText(book.getTitle());
            authorTf.setText(book.getAuthor());
            pageCountTf.setText(String.valueOf(book.getPageCount()));
            copyCountTf.setText(String.valueOf(book.getCopyCount()));
            publishDateTf.setText(book.getPublishDate());
            isbanTf.setText(book.getIsbn());
            publisherTf.setText(book.getPublisher());
            languagesComboBox.setValue(book.getLanguage());
            formCategoryComboBox.setValue(book.getCatgeory());
            if (book.getBookImagePath() != null) {
                formBookImage.setImage(new Image("file:src" + book.getBookImagePath()));
            }
        }
    }

    @FXML
    private void openCategoryStage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Category.fxml"));
        Scene categoryScene = new Scene(root);
        stageData(CategoryStage, categoryScene, "book.jpg", "Category Screen", 450, 150);
        AdminStage.close();
        CategoryStage.show();

    }

    @FXML
    private void cancleBook(ActionEvent event) {
        titleTf1.clear();
        authorTf.clear();
        pageCountTf.clear();
        copyCountTf.clear();
        publishDateTf.clear();
        isbanTf.clear();
        publisherTf.clear();
        languagesComboBox.setValue("");
        formCategoryComboBox.setValue("");
        this.bookImageName = null;
        formBookImage.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/book.jpg")));

    }

    //------------------------------------------
    public static void stageData(Stage stage, Scene scene, String logo, String title,
            int x, int y) {
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setX(x);
        stage.setY(y);
        setStageImageIcon(stage, logo);

    }

    public boolean isNumeric(String page, String copy) {
        try {
            Integer.parseInt(page);
            Integer.parseInt(copy);

            return true;

        } catch (NumberFormatException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "page count or Copy count must be a nubmer!");
            alert.showAndWait();
            return false;
        }
    }

    public boolean bookExist(String isbn) {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookFound = true;
            }
        }
        return bookFound;
    }

    public void saveImage(Image img, String name) throws IOException {
        if (img != null) {

            String projectPath = System.getProperty("user.dir");
            String imagesFolderPath = projectPath + "/src/images";

            File imagesFolder = new File(imagesFolderPath);
            if (!imagesFolder.exists()) {
                imagesFolder.mkdir();
            }
            String fullFilePath = imagesFolderPath + "/" + name;

            File file = new File(fullFilePath);
            BufferedImage BI = SwingFXUtils.fromFXImage(img, null);
            ImageIO.write(BI, "png", file);
        } else {
            throw new IOException("Image is null.");
        }
    }

    public boolean UserExiest(String userName, String password) {
        boolean userFound = false;
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userFound = true;

            }
        }
        return userFound;
    }

    @FXML
    private void ShowSideBarStatistic(MouseEvent event) {
        SetSelectedSidebar(SideBarStatistic, AnchorPaneStatistic);

    }

    @FXML
    private void LogOutSystem(MouseEvent event) {
        LogOut(event);
    }

//    @FXML
//    private void showUsersStatistic(MouseEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/Views/UserStatistic.fxml"));
//        Scene RiScene = new Scene(root);
//        SceneBuilderLibrarySystem.stageData(SceneBuilderLibrarySystem.UserStatistic,
//                RiScene, "images.png", "UsersStatistic", 300, 60);
//       
//      
//        SceneBuilderLibrarySystem.UserStatistic.show();
//        SceneBuilderLibrarySystem.AdminStage.hide();
//    }
    @FXML
    private void showUsersStatistic(MouseEvent event) throws IOException {
        String selectedRole = "";
        if (event.getSource() == adminImage) {
            selectedRole = "Admin";
        } else if (event.getSource() == userImage) {
            selectedRole = "User";
        } else if (event.getSource() == librarianImage) {
            selectedRole = "Libriran";
        } else if (event.getSource() == all) {
            selectedRole = "All";
        }

        ObservableList<User> filteredUsers = FXCollections.observableArrayList();
        for (User user : users) {
            if (selectedRole.equals("All") || selectedRole.equals(user.getRole())) {
                filteredUsers.add(user);
            }
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/UserStatistic.fxml"));
        Parent root = loader.load();

        UserStatisticController controller = loader.getController();
        controller.setTableData(filteredUsers);

        Scene RiScene = new Scene(root);
        SceneBuilderLibrarySystem.stageData(SceneBuilderLibrarySystem.UserStatistic, RiScene, "images.png", "UsersStatistic", 300, 60);
        SceneBuilderLibrarySystem.UserStatistic.show();
        SceneBuilderLibrarySystem.AdminStage.hide();
    }

}
