package controllers;

import exceptions.UsernameAlreadyExists;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import exceptions.UsernameAlreadyExists;
import javafx.stage.Stage;
import services.UserService;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Student", "Teacher");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExists e) {
            registrationMessage.setText(e.getMessage());
        }
    }
    public void loadLoginPage(){
        try {
            Stage stage = (Stage) registrationMessage.getScene().getWindow();
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/javafx/Login.fxml"));
            Scene scene = new Scene(loginRoot, 640, 480);
            stage.setTitle("Login page");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

