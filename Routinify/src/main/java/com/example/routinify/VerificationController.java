package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VerificationController {
    @FXML
    private Parent root;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private TextField otp;

    @FXML
    private Label lb;

    @FXML
    protected void onClick(ActionEvent event) throws IOException {
        if (otp.getText().length() < 6) {
            lb.setText("OTP must be 6 digits");
            lb.setTextFill(Color.RED);
        } else {
            lb.setText("");
            String st="";
            File file = new File("otp.txt");
            Scanner sc= new Scanner(file);
            while (sc.hasNextLine()){
                st=sc.nextLine();
            }
            if (st.equals(otp.getText())) {
                root = FXMLLoader.load(getClass().getResource("NewPass.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                lb.setText("Wrong OTP");
                lb.setTextFill(Color.RED);
            }
        }
    }
}

