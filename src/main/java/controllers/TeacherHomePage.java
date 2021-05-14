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

public class TeacherHomePage implements Initializable {
    //Log out button -> Login.fxml
    public void logoutButtonTeacher(ActionEvent event) throws IOException{
        Parent parent1 = FXMLLoader.load(getClass().getResource("/javafx/Login.fxml"));

        Scene parent1_scene = new Scene(parent1);
        Stage parent1_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        parent1_stage.setScene(parent1_scene);
        parent1_stage.setTitle("Teacher Home Page");
        parent1_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
