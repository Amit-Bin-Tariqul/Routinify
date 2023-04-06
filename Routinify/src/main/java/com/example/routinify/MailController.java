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


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;


public class MailController {
    @FXML
    private TextField user;
    @FXML
    private TextField email;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Label usLabel;
    @FXML
    private Label emLabel;

    private String otp;

    @FXML
    protected void onClickOK(ActionEvent event) throws IOException, SQLException, MessagingException {
        if(user.getText().length()==0){
            usLabel.setText("Enter valid username");
            emLabel.setText("");
            usLabel.setTextFill(Color.RED);
        }
        else if(email.getText().length()==0){
            usLabel.setText("");
            emLabel.setText("Enter valid email");
            emLabel.setTextFill(Color.RED);
        }
        else {

            Database database = new Database();
            if(database.emailExists(user.getText(),email.getText())){
                Properties properties = new Properties();
                properties.put("mail.smtp.auth",true);
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port",587);
                properties.put("mail.smtp.starttls.enable",true);
                properties.put("mail.transport.protocol","smtp");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("amitbintariqul@gmail.com","tlmcxvygjxxivbyu");
                    }
                });

                Message message = new MimeMessage(session);
                otp = OTPGenerator();

                FileWriter file= new FileWriter("otp.txt");
                file.write(otp);
                file.close();

                message.setSubject("Password Verification");
                message.setText("COngratulations.Your request to change Password has been acknowledged.\nYour OTP is "+otp);

                Address addressTo = new InternetAddress("amitbintariqul@gmail.com");
                message.setRecipient(Message.RecipientType.TO, addressTo);

                Transport.send(message);


                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verification");
                alert.setContentText("OTP has been sent to your mail successfully.");
                alert.showAndWait();

                root = FXMLLoader.load(getClass().getResource("Verify.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else {
                emLabel.setText("Credentials do not match.");
                emLabel.setTextFill(Color.RED);
            }
        }

    }

    @FXML
    protected static String  OTPGenerator() {

        int randnum=(int) (Math.random()*900000)+100000;
        String otp= String.valueOf(randnum);
        return otp;

    }
   public String getOtp(){
        return otp;
    }
}
