/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenebuilderlibrarysystem;

import DataBase.BookDataBaseHandeler;
import DataBase.BorrowBookDataBaseHandler;
import DataBase.DataBaseConnection;
import DataBase.UserDataBaseHandeler;
import Model.Book;
import Model.BorrowBook;
import Model.BorrowBookDetailes;
import Model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author awadallah
 */
public class SceneBuilderLibrarySystem extends Application {

    public static Stage LoginStage = new Stage();
    public static Stage RegisterStage = new Stage();
    public static Stage AdminStage = new Stage();
    public static Stage LibririanStage = new Stage();
    public static Stage UserStage = new Stage();
    public static User userLogin = null;
    public static Stage bookManagment = new Stage();
    public static Stage UserProfileStage = new Stage();
    public static Stage CategoryStage = new Stage();
    public static Stage UserStatistic = new Stage();
    public static Stage bookStatistic = new Stage();
    public static Stage allBooksStage = new Stage();

    public static ObservableList<User> users = FXCollections.observableArrayList();
    public static ObservableList<String> categories = FXCollections.observableArrayList();
    public static ObservableList<Book> books = FXCollections.observableArrayList();
    public static ObservableList<BorrowBook> borrowBooks = FXCollections.observableArrayList();
    public static ObservableList<BorrowBookDetailes> borrowBooksDetailes = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Login.fxml"));
        Scene LoginScene = new Scene(root);
        stageData(LoginStage, LoginScene, "logo.jpg", "Login Screen", 450, 150);
        LoginStage.show();

//------------------load data--------------
        users.setAll(UserDataBaseHandeler.getUsersData());
        books.addAll(BookDataBaseHandeler.getBooksData());
        borrowBooksDetailes.addAll(BorrowBookDataBaseHandler.getBorrowDetails());
        
    }

//---------------------------------------
    public static void setStageImageIcon(Stage s, String logo) {
        s.getIcons().add(new Image(SceneBuilderLibrarySystem.class.getResourceAsStream("/images/" + logo)));
    }

    public static void stageData(Stage stage, Scene scene, String logo, String title,
            int x, int y) {
        stage.setScene(scene);
        stage.setTitle(title);

        stage.setX(x);
        stage.setY(y);
        setStageImageIcon(stage, logo);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
