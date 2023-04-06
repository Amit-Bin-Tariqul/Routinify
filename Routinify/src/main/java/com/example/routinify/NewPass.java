package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class NewPass {
    @FXML
    private TextField newpass;
    @FXML
    private TextField reconfirm;
    @FXML
    private TextField user;
    @FXML
    private Label usLabel;
    @FXML
    private Label np;
    @FXML
    private Label rec;
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    protected void onClick(ActionEvent event) throws IOException, SQLException {
        if(user.getText().length()==0){
            usLabel.setTextFill(Color.RED);
            usLabel.setText("Enter valid name");
            np.setText("");
            rec.setText("");
        }
        else if(newpass.getText().length()==0){
            usLabel.setText("");
            np.setTextFill(Color.RED);
            np.setText("Enter valid Password");
            rec.setText("");
        }
        else if(!(reconfirm.getText().equals(newpass.getText()))){
            rec.setTextFill(Color.RED);
            rec.setText("Passwords do not match");
            usLabel.setText("");
            np.setText("");
        }
        else
        {
            Database database=new Database();
            database.setNewPassword(user.getText(),newpass.getText());
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Successfully changed");
            alert.showAndWait();
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
