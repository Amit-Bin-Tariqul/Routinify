package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SemesterController {

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    Button s1;
    @FXML
    Button s2;
    @FXML
    Button s3;
    @FXML
    Button s4;
    @FXML
    Button s5;
    @FXML
    Button s6;
    @FXML
    Button s7;
    @FXML
    Button s8;

    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UserFunction.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSemesterclick(ActionEvent event) throws IOException {

        if (event.getSource() == s1) {
            root = FXMLLoader.load(getClass().getResource("FirstSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
//            stage.setHeight(800);
//            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == s2) {
            root = FXMLLoader.load(getClass().getResource("SecondSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
//            stage.setHeight(800);
//            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == s3) {
            root = FXMLLoader.load(getClass().getResource("ThirdSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setHeight(800);
            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == s4) {
            root = FXMLLoader.load(getClass().getResource("FourthSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setHeight(800);
            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == s5) {
            root = FXMLLoader.load(getClass().getResource("FifthSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setHeight(800);
            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == s6) {
            root = FXMLLoader.load(getClass().getResource("SixthSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setHeight(800);
            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();

        }
        else if (event.getSource() == s7) {
            root = FXMLLoader.load(getClass().getResource("SeventhSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setHeight(800);
            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
        else {
            root = FXMLLoader.load(getClass().getResource("EighthSemester.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setHeight(800);
            stage.setWidth(900);
            stage.setScene(scene);
            stage.show();
        }
    }

}
