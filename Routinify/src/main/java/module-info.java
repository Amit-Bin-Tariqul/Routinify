module com.example.routinify {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.mail;


    opens com.example.routinify to javafx.fxml;
    exports com.example.routinify;
}