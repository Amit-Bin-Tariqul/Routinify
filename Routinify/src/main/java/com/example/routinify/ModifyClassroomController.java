package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ModifyClassroomController {

    @FXML
    Parent root;
    @FXML
    Scene scene;
    @FXML
    Stage stage;

    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt;

    @FXML
    private TextField ClassroomNo;
    @FXML
    private TextField AcademicBuilding;
//    @FXML
//    private TextField courseCredit;



    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyDatabase.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("ModifyDatabase.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onClickAdd(ActionEvent event) throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
        stmt= connection.createStatement();
        String query = "INSERT INTO `classrooms` values(?, ?)";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, Integer.parseInt(ClassroomNo.getText()));
        pstmt.setString(2, AcademicBuilding.getText());
        pstmt.executeUpdate();
    }


}

