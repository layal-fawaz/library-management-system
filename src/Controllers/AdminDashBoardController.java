/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Model.Book;
import Model.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import scenebuilderlibrarysystem.SceneBuilderLibrarySystem;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.AdminStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.LoginStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.UserProfileStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.books;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.categories;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.stageData;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.userLogin;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.users;


/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class AdminDashBoardController implements Initializable {


    private Label homeSideBar;
    private Label userManagementSideBar;
    private Label bookManagementSideBar;
    @FXML
    private AnchorPane homeAnchor;
    @FXML
    private AnchorPane userManagementAnchor;
    @FXML
    private AnchorPane BookManagementAnchor;
    private ImageView userProfileImage;
    private Label userProfileLabel;
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
    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private TableView<User> tabelViewUser;
    @FXML
    private TableColumn<User, String> fullNameColumn;
    @FXML
    private TableColumn<User, String> RoleColumn;
    @FXML
    private TableColumn<User, String> userNameColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> phoneNumberColumn;
    @FXML
    private TableColumn<User, ImageView> imageViewColumn;
    Image[] profileImages = {null};
    String imageName = null;
    @FXML
    private Label roleLabelError;
    private TextField titleTxt;
    private Label titleLabelError;
    private TextField isbnTxt;
    private TextField publisherTxt;
    @FXML
    private Label publisherLabelError;
    private TextField pageCountTxt;
    @FXML
    private Label pageCountLabelError;
    private ComboBox<String> langaugeComboBox;
    private TextField copyCountTxt;
    @FXML
    private Label copyCountLabelError;
    private ImageView bookImage;
    private Label bookImageLabelError;
    private static ComboBox<String> categoryComboBox;
    private TextField authorTxt;
    @FXML
    private Label authorLabelError;
    private ComboBox<String> CategoryFilterComboBox;
    private TableColumn<Book, String> titleCoulmn;
    private TableColumn<Book, String> isbnColoumn;
    private TableColumn<Book, String> authorColoumn;
    private TableColumn<Book, String> publishDateColoumn;
    private TableColumn<Book, String> publisherColoumn;
    private TableColumn<Book, String> copyCountColoumn;
    private TableColumn<Book, String> pageCountColoumn;
    private TableColumn<Book, String> categoryColoumn;
    private TableColumn<Book, String> languageColoumn;
    private TableColumn<Book, ImageView> bookImageColoumn;
    @FXML
    private TableView<Book> tableViewBook;
    private Label isbnLabelError;
    private TextField publishDateTxt;
    @FXML
    private Label publishDateLabelError;

    public static String imageBookName = null;
  static Image[] bookImages = {null};
    @FXML
    private ImageView UserProfileImage;
    @FXML
    private Label UserProfileFullName;
    @FXML
    private Label SidebareHome;
    @FXML
    private Label SidebareUserManagments;
    @FXML
    private AnchorPane userManagementAnchor1;
    @FXML
    private Label phoneNumberLabel1;
    @FXML
    private Label phoneNumberLabelError11;
    @FXML
    private Label userNameLabel1;
    @FXML
    private Label passwordLabel1;
    @FXML
    private Label fullNameLabel1;
    @FXML
    private Label emailabel1;
    @FXML
    private Label profileImageViewLabelError1;
    @FXML
    private TextField pageCountTf;
    @FXML
    private TextField copyCountTf;
    @FXML
    private TextField isbanTf;
    @FXML
    private Label isbanLabelError;
    @FXML
    private TextField authorTf;
    @FXML
    private TextField titleTf1;
    @FXML
    private Label titleLabelError1;
    @FXML
    private ComboBox<?> languagesComboBox;
    @FXML
    private Label languagesComboBoxLabelError;
    @FXML
    private ImageView formBookImage;
    @FXML
    private Label formBookImageLabelError;
    @FXML
    private Label fullNameLabel11;
    @FXML
    private TextField publishDateTf;
    @FXML
    private Label fullNameLabel12;
    @FXML
    private TextField publisherTf;
    @FXML
    private Label phoneNumberLabelError111;
    @FXML
    private ComboBox<?> formCategoryComboBox;
    @FXML
    private ComboBox<?> BookFilter;
    @FXML
    private TableColumn<?, ?> titleColumn;
    @FXML
    private TableColumn<?, ?> authorColumn;
    @FXML
    private TableColumn<?, ?> isbanColumn;
    @FXML
    private TableColumn<?, ?> catgeoryColumn;
    @FXML
    private TableColumn<?, ?> languageColumn;
    @FXML
    private TableColumn<?, ?> copyCountColumn;
    @FXML
    private TableColumn<?, ?> pageCountColumn;
    @FXML
    private TableColumn<?, ?> BookimageViewColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        homeSideBar.getStyleClass().add("sideBarLabel");
        userManagementSideBar.getStyleClass().add("sideBarLabel");
        bookManagementSideBar.getStyleClass().add("sideBarLabel");
  //     setSelectedSideBar(homeSideBar, homeAnchor);

        //--------------------imageView
        userProfileImage.setImage(new Image(userLogin.getProfileImagePath()));


        userProfileLabel.setText(userLogin.getFullName());
//        userProfileImage.imageProperty().bind(
//                Bindings.createObjectBinding(() -> new Image(userLogin.getProfileImagePath()), userLogin.getProfileImagePath())
//        );
//        userProfileLabel.textProperty().bind(userLogin.getFullName());

        //set role data----------
        role.getItems().addAll("User", "Libririan", "Admin");
        roleComboBox.getItems().addAll("All", "User", "Libririan", "Admin");


        //set cell data------------------
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        RoleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        imageViewColumn.setCellValueFactory(cellData -> {
            ImageView bookImage = new ImageView(cellData.getValue().getProfileImagePath());
            bookImage.setFitHeight(60);
            bookImage.setFitWidth(60);

            return new SimpleObjectProperty<>(bookImage);

        });
System.out.println("Checking object: " );
        //--------------------------
        langaugeComboBox.getItems().addAll("Ar", "Eng");
        System.out.println("Checking object: " );

        categories.addAll("Stories", "languages");
        CategoryFilterComboBox.getItems().addAll(categories);
        CategoryFilterComboBox.getItems().add(0, "All");

        //set cells book data----------------------
        titleCoulmn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColoumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbnColoumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        publishDateColoumn.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
        pageCountColoumn.setCellValueFactory(new PropertyValueFactory<>("pageCount"));
        copyCountColoumn.setCellValueFactory(new PropertyValueFactory<>("copyCount"));
        categoryColoumn.setCellValueFactory(new PropertyValueFactory<>("catgeory"));
        publisherColoumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        languageColoumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        bookImageColoumn.setCellValueFactory(cellData -> {
            ImageView bookImageVeiw = new ImageView(cellData.getValue().getBookImagePath());
            bookImageVeiw.setFitHeight(40);
            bookImageVeiw.setFitWidth(40);

            return new SimpleObjectProperty<>(bookImageVeiw);

        });
        tableViewBook.setItems(books);

    }

    //------------------------------------------------------------------
    private void showHomeSidebar(MouseEvent event) {
        setSelectedSideBar(homeSideBar, homeAnchor);
    }

    private void showUserManagementSideBar(MouseEvent event) {
        setSelectedSideBar(userManagementSideBar, userManagementAnchor);

    }

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
        userManagementAnchor.setVisible(false);
        anchor.setVisible(true);
    }

    private void logOut(MouseEvent event) {
        AdminStage.close();
        LoginStage.show();
    }

    @FXML
    private void uploadUserImage(MouseEvent event) {
        FileChooser fileCh = new FileChooser();
        File file = fileCh.showOpenDialog(AdminStage);
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

    }

    @FXML
    private void addUser(ActionEvent event) {
        fullNameLabelError.setText("");
        usernameLabelError.setText("");
        passwordLabelError.setText("");
        emailLabelError.setText("");
        phoneNumberLabelError.setText("");
        roleLabelError.setText("");
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
            phoneNumberLabelError.setText("phoneNum is required");
            hasError = true;

        }

        if (role.getValue().isEmpty()) {
            roleLabelError.setText("role is required");
            hasError = true;

        }
        if (this.imageName == null || this.imageName.isEmpty()) {
            imageLabelError.setText("picture is required");
            hasError = true;
        }

        if (!hasError) {
            boolean isFound = userExist(usernameTxt.getText(), passwordTxt.getText());
            if (!isFound) {

                User newUser = new User(fullNameTxt.getText(), usernameTxt.getText(),
                        passwordTxt.getText(), emailTxt.getText(), phoneNumberTxt.getText(),
                        roleComboBox.getValue(), this.imageName.toString());

                users.add(newUser);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "user has been added");
                alert.showAndWait();

//clear inputs-------------------
                usernameTxt.clear();
                passwordTxt.clear();
                fullNameTxt.clear();
                emailTxt.clear();
                phoneNumberTxt.clear();
                role.setValue("");
                this.imageName = null;
                profileImageView.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/images.png")));
            
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "user is alredy exist");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void showLoginPage(ActionEvent event) throws IOException {

    }

    @FXML
    private void setSelectedUserForm(MouseEvent event) {
        User user = tabelViewUser.getSelectionModel().getSelectedItem();
        if (user != null) {
            fullNameTxt.setText(user.getFullName());
            usernameTxt.setText(user.getUserName());
            passwordTxt.setText(user.getPassword());
            emailTxt.setText(user.getEmail());
            phoneNumberTxt.setText(user.getPhoneNumber());
            roleComboBox.setValue(user.getRole());

            profileImages[0] = new Image(SceneBuilderLibrarySystem.class.getResourceAsStream(user.getProfileImagePath()));
            profileImageView.setImage(profileImages[0]);
        }
    }

    @FXML
    private void setUserFilterData(MouseEvent event) {
        String selectedRole = roleComboBox.getValue();
        //-----------------------------------------------------------
        ObservableList<User> filteredUsers = FXCollections.observableArrayList();

        if (selectedRole != null) {
            if (selectedRole.equals("All")) {
                filteredUsers.addAll(users);
            } else {
                for (User user : users) {
                    if (user.getRole().trim().equalsIgnoreCase(selectedRole.trim())) {
                        filteredUsers.add(user);
                    }
                }
            }

            tabelViewUser.setItems(filteredUsers);
        }
    }

    @FXML
    private void updateUser(ActionEvent event) {
        User selectedUser = tabelViewUser.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            for (User user : users) {
                if (user.getUserName().equals(selectedUser.getUserName())) {
                    selectedUser = user;
                    break;
                }
            }

            boolean sameUserFound = false;
            for (User user : users) {
                if (selectedUser.getUserName().equals(usernameTxt.getText())) {
                    continue;
                }

                if (user.getUserName().equals(usernameTxt.getText())) {
                    sameUserFound = true;
                    break;
                }
            }

            if (selectedUser != null) {
                if (!sameUserFound) {

                    selectedUser.setFullName(fullNameTxt.getText());
                    selectedUser.setUserName(usernameTxt.getText());
                    selectedUser.setPassword(passwordTxt.getText());
                    selectedUser.setEmail(emailTxt.getText());
                    selectedUser.setPhoneNumber(phoneNumberTxt.getText());
                    selectedUser.setRole(roleComboBox.getValue());
                    if (this.imageName != null) {
                        selectedUser.setProfileImagePath(this.imageName);
                    }

                    tabelViewUser.setItems(users);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Updated");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "User Name used by another Acount");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Select User To Update");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        User selectedUser = tabelViewUser.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            for (User user : users) {
                if (user.getUserName().equals(selectedUser.getUserName())) {
                    users.remove(user);
                    usernameTxt.clear();
                    passwordTxt.clear();
                    fullNameTxt.clear();
                    emailTxt.clear();
                    phoneNumberTxt.clear();
                    this.imageName = null;
                    if (selectedUser.equals(userLogin)) {
                        AdminStage.close();
                        LoginStage.show();
                    }
//userProfileImage.setImage(new Image(is));
                    break;
                }
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR, ".....Select User To Delete");
            alert.showAndWait();
        }

    }

    public boolean userExist(String userName, String pass) {
        boolean userFound = false;
        for (User user : users) {
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

        String fullFilePath = imagesFolderPath + "/" + name;
        File f = new File(fullFilePath);
        BufferedImage bI = SwingFXUtils.fromFXImage(img, null);
        ImageIO.write(bI, "png", f);
    }

    @FXML
    private void cancle(MouseEvent event) {
        usernameTxt.clear();
        passwordTxt.clear();
        fullNameTxt.clear();
        emailTxt.clear();
        phoneNumberTxt.clear();
        this.imageName = null;
    }

    private void showUserProfileStage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/UserProfile.fxml"));
        Scene UserProfileScene = new Scene(root);
        stageData(UserProfileStage, UserProfileScene, "logo.jpg", "UserProfile Screen", 450, 150);
        AdminStage.close();
        UserProfileStage.show();
    }


    private void updateBook(ActionEvent event) {

        //------------------------update-----------------
        Book selectedBook = tableViewBook.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            for (Book book : books) {
                if (book.getTitle().equals(selectedBook.getTitle())) {
                    selectedBook = book;
                    break;
                }
            }

            boolean sameUserFound = false;
            for (Book book : books) {
                if (selectedBook.getTitle().equals(titleTxt.getText())) {
                    continue;
                }

                if (book.getTitle().equals(titleTxt.getText())) {
                    sameUserFound = true;
                    break;
                }
            }

            //---------------------------
            if (selectedBook != null) {
                if (bookExist(isbnTxt.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Book used by another Acount");
                    alert.showAndWait();
                } else {
                    if (!sameUserFound) {
                        if (isNumeric(copyCountTxt.getText(), pageCountTxt.getText())) {
                            selectedBook.setAuthor(authorTxt.getText());
                            selectedBook.setAuthor(authorTxt.getText());
                            selectedBook.setPageCount(pageCountTxt.getText());
                            selectedBook.setCopyCount(copyCountTxt.getText());
                            selectedBook.setIsbn(isbnTxt.getText());
                            selectedBook.setPublishDate(publishDateTxt.getText());
                            selectedBook.setPublisher(publisherTxt.getText());
                            selectedBook.setCatgeory(categoryComboBox.getValue());
                            selectedBook.setLanguage(langaugeComboBox.getValue());

                            if (this.imageBookName != null) {
                                selectedBook.setBookImagePath(this.imageBookName);
                            }

                            tableViewBook.refresh();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Updated");
                            alert.showAndWait();
                        }
                    }
                }

            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR, "Select Book To Update");
                alert.showAndWait();
            }

        }

    }

    private void cancleBook(ActionEvent event) {
        usernameTxt.clear();
        passwordTxt.clear();
        fullNameTxt.clear();
        emailTxt.clear();
        phoneNumberTxt.clear();
        role.setValue("");
        this.imageName = null;
        profileImageView.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/images")));
    }

    public void checkFields(boolean hasError) {
        titleLabelError.setText("");
        authorLabelError.setText("");
        publishDateLabelError.setText("");
        publisherLabelError.setText("");
        isbnLabelError.setText("");
        copyCountLabelError.setText("");
        pageCountLabelError.setText("");

        hasError = false;

        if (titleTxt.getText().isEmpty()) {
            titleLabelError.setText("title is required");
            hasError = true;
            titleLabelError.getStyleClass().add("labelError");

        }

        if (publisherTxt.getText().isEmpty()) {
            publisherLabelError.setText("publisher is required");
            hasError = true;
            publisherLabelError.getStyleClass().add("labelError");

        }

        if (copyCountTxt.getText().isEmpty()) {
            copyCountLabelError.setText("copyCount is required");
            hasError = true;
            copyCountLabelError.getStyleClass().add("labelError");
        }

        if (authorTxt.getText().isEmpty()) {
            authorLabelError.setText("author is required");
            hasError = true;
            authorLabelError.getStyleClass().add("labelError");

        }
        if (isbnTxt.getText().isEmpty()) {
            isbnLabelError.setText("ISBN is required");
            hasError = true;

        }
        if (publishDateTxt.getText().isEmpty()) {
            publishDateLabelError.setText("publish Data is required");
            hasError = true;

        }

        if (pageCountTxt.getText().isEmpty()) {
            pageCountLabelError.setText("page Count is required");
            hasError = true;

        }

        if (this.imageBookName == null || this.imageBookName.isEmpty()) {
            bookImageLabelError.setText("picture is required");
            hasError = true;

            bookImageLabelError.getStyleClass().add("labelError");

        }

    }

    private void addBook(ActionEvent event) {
        checkFields(false);
        /*
        titleLabelError.setText("");
        authorLabelError.setText("");
        publishDateLabelError.setText("");
        publisherLabelError.setText("");
        isbnLabelError.setText("");
        copyCountLabelError.setText("");
        pageCountLabelError.setText("");

        boolean hasError = false;

        if (titleTxt.getText().isEmpty()) {
            titleLabelError.setText("title is required");
            hasError = true;
            titleLabelError.getStyleClass().add("labelError");

        }

        if (publisherTxt.getText().isEmpty()) {
            publisherLabelError.setText("publisher is required");
            hasError = true;
            publisherLabelError.getStyleClass().add("labelError");

        }

        if (copyCountTxt.getText().isEmpty()) {
            copyCountLabelError.setText("copyCount is required");
            hasError = true;
            copyCountLabelError.getStyleClass().add("labelError");
        }

        if (authorTxt.getText().isEmpty()) {
            authorLabelError.setText("author is required");
            hasError = true;
            authorLabelError.getStyleClass().add("labelError");

        }
        if (isbnTxt.getText().isEmpty()) {
            isbnLabelError.setText("ISBN is required");
            hasError = true;

        }
        if (publishDateTxt.getText().isEmpty()) {
            publishDateLabelError.setText("publish Data is required");
            hasError = true;

        }

        if (pageCountTxt.getText().isEmpty()) {
            pageCountLabelError.setText("page Count is required");
            hasError = true;

        }

        if (this.imageBookName == null || this.imageBookName.isEmpty()) {
            bookImageLabelError.setText("picture is required");
            hasError = true;

            bookImageLabelError.getStyleClass().add("labelError");

        }

        if (!hasError)*/
        if(true)
        {
            if (bookExist(isbnTxt.getText())) {
                isbnLabelError.setText("Book already exists");
            } else {
                Book newBook = new Book(titleTxt.getText(), authorTxt.getText(),
                        isbnTxt.getText(), publishDateTxt.getText(), pageCountTxt.getText(),
                        copyCountTxt.getText(),
                        publisherTxt.getText(), this.imageBookName.toString(),
                        categoryComboBox.getValue(),
                        langaugeComboBox.getValue());

                if (isNumeric(copyCountTxt.getText(), pageCountTxt.getText())) {
                    books.add(newBook);
                    tableViewBook.setItems(books);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book added");
                    alert.showAndWait();

                    //clear inputs-------------------
                    alert.showAndWait();
                    titleTxt.clear();
                    authorTxt.clear();
                    publishDateTxt.clear();
                    publisherTxt.clear();
                    isbnTxt.clear();
                    copyCountTxt.clear();
                    pageCountTxt.clear();
                    langaugeComboBox.setValue("");
                    categoryComboBox.setValue("");
                    this.imageName = null;
                    bookImage.setImage(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/book.jpg")));
                }
            }

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

    //----------------------------------------------delete
    private void deleteBook(ActionEvent event) {
        Book selectedBook = tableViewBook.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            for (Book book : books) {
                if (book.getTitle().equals(selectedBook.getTitle())) {
                    books.remove(book);
                    titleTxt.clear();
                    authorTxt.clear();
                    publishDateTxt.clear();
                    publisherTxt.clear();
                    isbnTxt.clear();
                    copyCountTxt.clear();
                    pageCountTxt.clear();
                    this.imageName = null;
                    break;
                }
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR, ".....Select book To Delete");
            alert.showAndWait();
        }

    }

    private void uploadBookImage(MouseEvent event) {
        FileChooser fileCh = new FileChooser();
        File file = fileCh.showOpenDialog(AdminStage);
        if (file != null) {
            bookImages[0] = new Image(file.toURI().toString());
            bookImage.setImage(bookImages[0]);
            this.imageBookName = "/images/" + file.getName();

            try {
                saveImage(bookImages[0], file.getName());
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }

    }

    private void setBookCategory(ActionEvent event) {
        String selectedCategeory = CategoryFilterComboBox.getValue();
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
                tableViewBook.setItems(filteredCategeory);

            }
        }
    }

    //table view listener-------------------------------------------
    private void setSelectedBooktoForm(MouseEvent event) {
        Book book = tableViewBook.getSelectionModel().getSelectedItem();

        if (book != null) {
            bookImages[0] = new Image(SceneBuilderLibrarySystem.class
                    .getResourceAsStream(book.getBookImagePath()));
            bookImage.setImage(bookImages[0]);
            titleTxt.setText(book.getTitle());
            authorTxt.setText(book.getAuthor());
            publishDateTxt.setText(book.getPublishDate());
            publisherTxt.setText(book.getPublisher());
            isbnTxt.setText(book.getIsbn());
            copyCountTxt.setText(book.getCopyCount());
            pageCountTxt.setText(book.getPageCount());
            langaugeComboBox.setValue(book.getLanguage());
            categoryComboBox.setValue(book.getCatgeory());

        }

    }

    @FXML
    private void ShowUserProfileStage(MouseEvent event) {
    }

    @FXML
    private void LogOut(MouseEvent event) {
    }

    @FXML
    private void ShowSidebareHome(MouseEvent event) {
    }

    @FXML
    private void ShowSidebareUserManagments(MouseEvent event) {
    }

    @FXML
    private void ShowSidebareBookManagments(MouseEvent event) {
    }

    @FXML
    private void UplodeformBookImage(MouseEvent event) {
    }

    @FXML
    private void SetBookCategoryFilterTableData(ActionEvent event) {
    }

    @FXML
    private void openCategoryStage(MouseEvent event) {
    }

}
