package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StudentListController implements Initializable{
    public TextField textfieldFname;
    public TextField textfieldLname;
    public TableView tableview;
    public TableColumn colFirstName;
    public TableColumn colLastName;

    //  Back button -> Home Page.fxml
    public void logoutButtonStudent(ActionEvent event) throws IOException {
        Parent parent2 = FXMLLoader.load(getClass().getResource("/javafx/TeacherHomePage.fxml"));

        Scene parent2_scene = new Scene(parent2);
        Stage parent2_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        parent2_stage.setScene(parent2_scene);
        parent2_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void buttonAdd(ActionEvent actionEvent) {
        Student student = new Student(textfieldFname.getText(),textfieldLname.getText());
        // student.setFirstName(textfieldFname.getText());
        // student.setLastName(textfieldLname.getText());
        tableview.getItems().add(student);
        textfieldFname.clear();
        textfieldLname.clear();

    }
}
