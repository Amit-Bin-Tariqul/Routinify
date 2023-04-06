package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private TextField confirmPass;
    @FXML
    private Label userLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label confirm;

    @FXML
    protected void onClickRegistrationBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickSignUp(ActionEvent event) throws SQLException,IOException {

        if(username.getText().length()==0){
            userLabel.setText("Enter valid Username");
            userLabel.setTextFill(Color.RED);
            passwordLabel.setText("");
            emailLabel.setText("");
            confirmPass.setText("");

        }
        else if(password.getText().length()==0){
            userLabel.setText("");
            passwordLabel.setText("Enter valid Password");
            passwordLabel.setTextFill(Color.RED);
            emailLabel.setText("");
            confirmPass.setText("");
        }
        else if (email.getText().length()==0) {
            userLabel.setText("");
            passwordLabel.setText("");
            emailLabel.setTextFill(Color.RED);
            emailLabel.setText("Enter valid Email");
            confirmPass.setText("");
        }
        else if (confirmPass.getText().length()==0 || !(confirmPass.getText().equals(password.getText()))) {
            userLabel.setText("");
            passwordLabel.setText("");
            emailLabel.setText("");
            confirm.setText("Passwords do not match");
            confirm.setTextFill(Color.RED);
        }
        else{
            Database database= new Database();
            database.addUser(username.getText(),password.getText(), email.getText());
            root = FXMLLoader.load(getClass().getResource("UserFunction.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }

    }
}
