package com.example.routinify;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button loger;
    @FXML
    private Button reg;
    @FXML
    private Button exit;
    @FXML
    private Button guide;

    @FXML
    protected void onClickLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickRegistration(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        scene.getStylesheets().add(getClass().getResource("registration.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onClickExit(ActionEvent event){
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loger.setOnMouseEntered(e -> {
            Label lb = (Label) loger.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setText("Login");
            lb.setTextFill(Color.WHITESMOKE);

        });
        reg.setOnMouseEntered(e -> {
            Label lb = (Label) reg.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setText("Register");
            lb.setTextFill(Color.WHITESMOKE);
        });
        guide.setOnMouseEntered(e -> {
            Label lb = (Label) guide.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setText("Guidelines");
            lb.setTextFill(Color.WHITESMOKE);
        });
        exit.setOnMouseEntered(e -> {
            Label lb = (Label) exit.getGraphic();
            lb.getGraphic().setOpacity(0);
            lb.getTooltip().setOpacity(0);
            lb.setText("Exit");
            lb.setTextFill(Color.WHITESMOKE);

        });

        loger.setOnMouseExited(e -> {
            Label lb = (Label) loger.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
        reg.setOnMouseExited(e -> {
            Label lb = (Label) reg.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
        guide.setOnMouseExited(e -> {
            Label lb = (Label) guide.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
        exit.setOnMouseExited(e -> {
            Label lb = (Label) exit.getGraphic();
            lb.getGraphic().setOpacity(1);
            lb.getTooltip().setOpacity(0);
            lb.setText("");
        });
    }
}
