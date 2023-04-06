package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ModifyDatabaseController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UserFunction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("userFunction.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onClickModifyCourse(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyCourse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("userFunction.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onClickModifyTeacher(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyTeacher.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("userFunction.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickModifyClassroom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyClassroom.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("userFunction.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
