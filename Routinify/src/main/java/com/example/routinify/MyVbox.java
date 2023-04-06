package com.example.routinify;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MyVbox extends VBox {

    private ComboBox<String>course;
    private ComboBox<String>teacher;
    private ComboBox<String>classroom;
    private TextField timeslot;
    private ComboBox<String>labgrp;
    public MyVbox(int sem){
        super();
        course= new ComboBox<>();
        teacher=new ComboBox<>();
        classroom=new ComboBox<>();
        timeslot=new TextField();
        labgrp= new ComboBox<>();

        course.prefWidthProperty().bind(this.widthProperty());
        course.prefHeightProperty().bind(this.heightProperty());
        course.setVisibleRowCount(5);

        teacher.prefWidthProperty().bind(this.widthProperty());
        teacher.prefHeightProperty().bind(this.heightProperty());
        teacher.setVisibleRowCount(5);

        classroom.prefWidthProperty().bind(this.widthProperty());
        classroom.prefHeightProperty().bind(this.heightProperty());
        classroom.setVisibleRowCount(5);

        timeslot.prefWidthProperty().bind(this.widthProperty());
        timeslot.prefHeightProperty().bind(this.heightProperty());

        labgrp.prefHeightProperty().bind(this.heightProperty());
        labgrp.prefWidthProperty().bind(this.widthProperty());
        labgrp.setVisibleRowCount(2);

        course.getItems().addAll("Hello");
        course.setValue("Enter Class");
        teacher.getItems().addAll("abc");
        teacher.setValue("Enter Teacher");
        classroom.getItems().addAll("507");
        classroom.setValue("Enter Room");
        timeslot.setPromptText("Enter time");
        labgrp.getItems().addAll("2A","2B");
        labgrp.setValue("Enter Labgrp");

        getChildren().addAll(course,teacher,classroom,timeslot,labgrp);
    }

}
