package com.example.routinify;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Math.random;

public class LoginController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label userLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    protected void onClickLoginBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickSignIn(ActionEvent event) throws IOException, SQLException {
        if(username.getText().length()==0){
            userLabel.setText("Enter valid Username");
            userLabel.setTextFill(Color.RED);
            passwordLabel.setText("");
        }
        else if(password.getText().length()==0){
            passwordLabel.setText("Enter valid Password");
            passwordLabel.setTextFill(Color.RED);
            userLabel.setText("");

        }
        else {
            Database database= new Database();
            if(database.userExists(username.getText(),password.getText())){
                root = FXMLLoader.load(getClass().getResource("UserFunction.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("userFunction.css").toExternalForm());
                stage.setScene(scene);
                stage.show();
            }
            else {
                passwordLabel.setText("User Credentials do not match.");
                passwordLabel.setTextFill(Color.RED);
            }
        }
    }

    @FXML
    protected void onClickForgotPassword(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Mail.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

