package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import exceptions.InvalidC;
import model.User;
import services.UserService;

import java.io.IOException;

public class Login {

    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    public void handleLoginAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username == null || username.isEmpty()) {
            loginMessage.setText("Add username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Add password!");
            return;
        }

        String encoded_password = UserService.encodePassword(username, password);

        try{
            String stored_password = UserService.getHashedUserPassword(username);
            if(stored_password.equals(encoded_password)){
                if(UserService.getUser(username).getRole().equals("Teacher")){
                    loadTeacherHomePage();
                    return;
                }
                if(UserService.getUser(username).getRole().equals("Student")){
                    loadStudentHomePage();
                    return;
                }
                return;
            }

        } catch(InvalidC e){
            loginMessage.setText(e.getMessage());
            return;
        }

        loginMessage.setText("Incorrect login!");
    }

    @FXML
    public void loadRegisterPage(){
        try {
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            Parent registerRoot = FXMLLoader.load(getClass().getResource("/javafx/registration.fxml"));
            Scene scene = new Scene(registerRoot, 640, 480);
            stage.setTitle("Login page");
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadTeacherHomePage(){
        try{
            User u = UserService.getUser(usernameField.getText());
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/TeacherHomePage.fxml"));
            Parent homeRoot = loader.load();
            Scene scene = new Scene(homeRoot, 640, 480);
            //stage.setTitle("English Courses");
            stage.setScene(scene);
        } catch (InvalidC e){
            loginMessage.setText(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    private void loadStudentHomePage(){
        try{
            User u = UserService.getUser(usernameField.getText());
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx/StudentHomePage.fxml"));
            Parent homeRoot = loader.load();
            Scene scene = new Scene(homeRoot, 640, 480);
            stage.setScene(scene);
        } catch (InvalidC e){
            loginMessage.setText(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
