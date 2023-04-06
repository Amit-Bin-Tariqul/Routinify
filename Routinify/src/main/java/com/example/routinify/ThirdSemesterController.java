package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ThirdSemesterController implements Initializable {

    @FXML
    private GridPane thirdSemGridpane;
    @FXML
    Parent root;
    @FXML
    Scene scene;
    @FXML
    Stage stage;
    @FXML
    private Button save;
    @FXML
    private Button export;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                MyVbox myVbox=new MyVbox(3);
                thirdSemGridpane.add(myVbox,i,j);
                myVbox.setAlignment(Pos.CENTER);
                myVbox.setSpacing(4);
                myVbox.setPrefHeight(200);
                myVbox.setPrefWidth(100);
            }
        }

    }

    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SemesterController.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
