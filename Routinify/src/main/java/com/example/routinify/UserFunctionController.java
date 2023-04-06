package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserFunctionController implements Initializable {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    protected void onClickModifyDatabase(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyDatabase.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("ModifyDatabase.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected  void onClickUpdateRoutine(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SemesterController.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("mainMenu.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        b1.setOnMouseEntered(e -> {
            Label lb = (Label) b1.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setFont(new Font(5));
            lb.setText("Modify Database");
            lb.setTextFill(Color.WHITESMOKE);
        });
        b2.setOnMouseEntered(e -> {
            Label lb = (Label) b2.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setFont(new Font(5));
            lb.setText("Update Routine");
            lb.setTextFill(Color.WHITESMOKE);
        });
        b3.setOnMouseEntered(e -> {
            Label lb = (Label) b3.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setFont(new Font(5));
            lb.setText("Back to Main Menu");
            lb.setTextFill(Color.WHITESMOKE);
        });


        b1.setOnMouseExited(e -> {
            Label lb = (Label) b1.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
        b2.setOnMouseExited(e -> {
            Label lb = (Label) b2.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
        b3.setOnMouseExited(e -> {
            Label lb = (Label) b3.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
    }
}
