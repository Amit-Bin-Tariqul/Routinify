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

public class ModifyCourseController {
    @FXML
    TextField courseCode;
    @FXML
    TextField credit;
    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ModifyDatabase.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onClickAdd(ActionEvent event) throws IOException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
        stmt= connection.createStatement();
        String query = "INSERT INTO courses values(?, ?)";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, courseCode.getText());
        pstmt.setInt(2, Integer.parseInt(credit.getText()));
        pstmt.executeUpdate();
    }

}
