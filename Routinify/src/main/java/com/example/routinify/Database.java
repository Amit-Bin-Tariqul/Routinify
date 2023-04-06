package com.example.routinify;

import java.sql.*;

public class Database {
    private Connection connection;
    private Statement stmt;
    private PreparedStatement pstmt;

    public boolean userExists(String user,String pss) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
        stmt= connection.createStatement();
        String query = "SELECT username, password FROM logininfo WHERE username=? AND password=SHA2(?,224)";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, user);
        pstmt.setString(2,pss);
        ResultSet rs= pstmt.executeQuery();
        if(rs.next()==false) return false;
        return true;
    }

    public boolean emailExists(String user,String mail) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
        stmt= connection.createStatement();
        String query = "SELECT username, email FROM logininfo WHERE username=? AND email=?";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, user);
        pstmt.setString(2,mail);
        ResultSet rs= pstmt.executeQuery();
        if(rs.next()==false) return false;
        return true;
    }

    public void addUser(String nam,String pass,String email) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
        stmt=connection.createStatement();
        pstmt = connection.prepareStatement ("insert into logininfo values (? ,SHA2(?,224) ,?)") ;
        pstmt.setString(1,nam);
        pstmt.setString(2,pass);
        pstmt.setString(3,email);
        pstmt.executeUpdate();
    }

    protected void setNewPassword(String user,String newpass) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
        stmt=connection.createStatement();
        pstmt = connection.prepareStatement ("UPDATE logininfo SET password = sha2(?,224) WHERE username = ?") ;
        pstmt.setString(1,newpass);
        pstmt.setString(2,user);
        pstmt.executeUpdate();
    }
}
