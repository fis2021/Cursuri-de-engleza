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

import static javafx.fxml.FXMLLoader.load;

public class TeacherLessonsController implements Initializable {
    //Back Button -> TeacherHomePage.fxml
    public void backButtonTeacher(ActionEvent event) throws IOException {
        Parent parent1 = load(getClass().getResource("/javafx/TeacherHomePage.fxml"));

        Scene parent3_scene = new Scene(parent1);
        Stage parent3_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        parent3_stage.setScene(parent3_scene);
        parent3_stage.show();
    }

    //Add Button -> AddLessonsTeacher.fxml
    public void addLessonButton(ActionEvent event) throws IOException {
        Parent parent6 = load(getClass().getResource("/javafx/AddLessonsTeacher.fxml"));

        Scene parent6_scene = new Scene(parent6);
        Stage parent6_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        parent6_stage.setScene(parent6_scene);
        parent6_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
