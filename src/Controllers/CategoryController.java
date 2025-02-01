/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.AdminStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.CategoryStage;
import static scenebuilderlibrarysystem.SceneBuilderLibrarySystem.categories;

/**
 * FXML Controller class
 *
 * @author awadallah
 */
public class CategoryController implements Initializable {

    @FXML
    private TextField categoryTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addCategory(ActionEvent event) {
        categories.add(categoryTxt.getText());
    }

    @FXML
    private void cancleStage(ActionEvent event) {
        CategoryStage.close();
        AdminStage.show();
    }
    
}
