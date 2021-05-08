package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //when this method is called it will change the scene from
    //log in to sign in
    private Label label;
    public void changeNotLoggedIn(ActionEvent event) throws IOException {
        Parent parent1 = FXMLLoader.load(getClass().getResource("registration.fxml"));

        Scene parent1_scene = new Scene(parent1);
        Stage app_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage.setScene(parent1_scene);
        app_stage.show();
    }

    //when this method is called it will change the scene from
    //sign in to log in
    public void changeSignIn(ActionEvent event) throws IOException{
        Parent parent2 = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene parent2_scene = new Scene(parent2);
        Stage app_stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        app_stage1.setScene(parent2_scene);
        app_stage1.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
