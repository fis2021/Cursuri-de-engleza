package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentHomePage implements Initializable {
    //Log out button -> Login.fxml
    public void logoutButtonStudent(ActionEvent event) throws IOException {
        Parent parent2 = FXMLLoader.load(getClass().getResource("/javafx/Login.fxml"));

        Scene parent2_scene = new Scene(parent2);
        Stage parent2_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        parent2_stage.setScene(parent2_scene);
        parent2_stage.setTitle("Student Home Page");
        parent2_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
