package com.example.routinify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class SecondSemesterController implements Initializable {
    private Integer semester = 2;
    private String programme = "CSE";
    private Integer section = 1;
    @FXML
    Stage stage;
    @FXML
    Parent root;
    @FXML
    Scene scene;
    @FXML
    Label myLabel;
    @FXML
    ComboBox<Course> myCourse1;
    @FXML
    ComboBox<Classroom> myClassroom1;
    @FXML
    ComboBox<Teacher> myTeacher1;
    @FXML
    ComboBox<Course> myCourse2;
    @FXML
    ComboBox<Classroom> myClassroom2;
    @FXML
    ComboBox<Teacher> myTeacher2;
    @FXML
    ComboBox<Course> myCourse3;
    @FXML
    ComboBox<Classroom> myClassroom3;
    @FXML
    ComboBox<Teacher> myTeacher3;
    @FXML
    ComboBox<Course> myCourse4;
    @FXML
    ComboBox<Classroom> myClassroom4;
    @FXML
    ComboBox<Teacher> myTeacher4;
    @FXML
    ComboBox<Course> myCourse5;
    @FXML
    ComboBox<Classroom> myClassroom5;
    @FXML
    ComboBox<Teacher> myTeacher5;
    @FXML
    ComboBox<Course>myCourse6;
    @FXML
    ComboBox<Classroom> myClassroom6;
    @FXML
    ComboBox<Teacher> myTeacher6;

    @FXML
    FlowPane flowPane;


    private Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
    private Statement stmt= connection.createStatement();

    private PreparedStatement pstmt;

    ArrayList<Classroom> classroomList = new ArrayList<Classroom>();
    ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    ArrayList<Course> courseList = new ArrayList<Course>();

    public SecondSemesterController() throws SQLException {
    }

    public void classroomEffect( ComboBox<Classroom> fxid,String _day, Integer _period){
        try {
            fxid.getValue().DatabaseAction(_day, _period);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        };
    }
    public void teacherEffect( ComboBox<Teacher> fxid,String _day, Integer _period){
        try {
            fxid.getValue().DatabaseAction(_day, _period);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        };
    }
    public void courseEffect( ComboBox<Course> fxid, String _day, Integer _period){
        try {
            fxid.getValue().DatabaseAction(_day, _period);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        };
    }


    public Classroom DataRetrieval(ArrayList<Classroom> t, String _day, Integer _period) throws SQLException {
        Classroom temp = null;
        String query = "SELECT * FROM classroom_routine where semester = ? AND programme = ? AND section = ? AND day = ? AND period = ?";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, semester);
        pstmt.setString(2, programme);
        pstmt.setInt(3, section);
        pstmt.setString(4, _day);
        pstmt.setInt(5, _period);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Classroom classroom = new Classroom(rs.getInt("classroomNo"), rs.getString("building"));
            temp = classroom;
        }
        return temp;
    }

    public Teacher DataRetrievalTeacher(ArrayList<Teacher> t, String _day, Integer _period) throws SQLException {
        Teacher temp = null;
        String query = "SELECT * from teachers where abbv in (SELECT abbv FROM teacher_routine where semester = ? AND programme = ? AND section = ? AND day = ? AND period = ?)";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, semester);
        pstmt.setString(2, programme);
        pstmt.setInt(3, section);
        pstmt.setString(4, _day);
        pstmt.setInt(5, _period);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Teacher teacher = new Teacher(rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), rs.getString("abbv"));
            temp = teacher;
        }
        return temp;
    }

    public Course DataRetrievalCourse(ArrayList<Course> t, String _day, Integer _period) throws SQLException {
        Course temp = null;
        String query = "SELECT * from courses where coursecode in (SELECT coursecode FROM course_routine where semester = ? AND programme = ? AND section = ? AND day = ? AND period = ?)";
        pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, semester);
        pstmt.setString(2, programme);
        pstmt.setInt(3, section);
        pstmt.setString(4, _day);
        pstmt.setInt(5, _period);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Course course = new Course(rs.getString("coursecode"), rs.getInt("coursecredit"));
            temp = course;
        }
        return temp;
    }
    public void classroomComboBoxFunction(ComboBox<Classroom> fxid, String _day, int _period) throws SQLException {
        String query = "SELECT * FROM  classrooms where classrooms.classroomNo not in (select classroomNo from classroom_routine where day = ? and period = ? and building in (select building from classroom_routine where day = ? and period = ?));";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, _day);
        pstmt.setInt(2,_period);
        pstmt.setString(3, _day);
        pstmt.setInt(4,_period);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            Classroom classroom = new Classroom(rs.getInt("classroomNo"), rs.getString("building"));
            fxid.getItems().addAll(classroom);
            classroomList.add(classroom);
        }
        fxid.getSelectionModel().select(DataRetrieval(classroomList, _day, _period));
        classroomList.clear();
    };

    public void teacherComboBoxFunction(ComboBox<Teacher> fxid, String _day, int _period) throws SQLException {
        String query = "SELECT * FROM  teachers where teachers.abbv not in (select abbv from teacher_routine where day = ? and period = ?);";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, _day);
        pstmt.setInt(2,_period);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            Teacher teacher = new Teacher(rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), rs.getString("abbv"));
            fxid.getItems().addAll(teacher);
            teacherList.add(teacher);
        }
        fxid.getSelectionModel().select(DataRetrievalTeacher(teacherList, _day, _period));
        teacherList.clear();
    };
    public void courseComboBoxFunction(ComboBox<Course> fxid, String _day, Integer _period) throws SQLException {
        String query = "SELECT * FROM  courses where courses.coursecode not in (select coursecode from course_routine where day = ? and period = ?);";
        pstmt = connection.prepareStatement(query);
        pstmt.setString(1, _day);
        pstmt.setInt(2, _period);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            Course course = new Course(rs.getString("coursecode"), rs.getInt("coursecredit"));
            fxid.getItems().addAll(course);
            courseList.add(course);
        }
        fxid.getSelectionModel().select(DataRetrievalCourse(courseList, _day, _period));
        courseList.clear();
    };

    public class Classroom{
        private Integer number;
        private String building;
        public Classroom(Integer n, String b){
            this.number = n;
            this.building = b;
        }

        public Integer getNumber(){
            return number;
        }

        public String getBuilding(){
            return building;
        }

        public void DatabaseAction(String _day, Integer _period) throws SQLException {
            String query = "DELETE FROM classroom_routine WHERE semester = ? AND programme = ? AND section = ? AND day = ? AND period = ?;";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, semester);
            pstmt.setString(2, programme);
            pstmt.setInt(3, section);
            pstmt.setString(4, _day);
            pstmt.setInt(5, _period);
            pstmt.execute();;
            query = "INSERT INTO classroom_routine values (?, ?, ?, ?, ?, ?, ?);";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, semester);
            pstmt.setString(2, programme);
            pstmt.setInt(3, section);
            pstmt.setString(4, _day);
            pstmt.setInt(5, _period);
            pstmt.setString(6, building);
            pstmt.setInt(7, number);
            pstmt.executeUpdate();
        }

        @Override
        public String toString(){
            return number.toString() + " " + building;
        }
    }
    public class Teacher{
        private String firstname;
        private String middlename;
        private String lastname;
        private String abbv;
        Teacher(String fn, String mn, String ln, String a){
            firstname = fn;
            middlename = mn;
            lastname = ln;
            abbv = a;
        }
        public String getFirstname() {
            return firstname;
        }

        public String getMiddlename() {
            return middlename;
        }

        public String getLastname() {
            return lastname;
        }

        public String getAbbv() {
            return abbv;
        }
        public void DatabaseAction(String _day, Integer _period) throws SQLException {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
            stmt= connection.createStatement();
            String query = "DELETE FROM teacher_routine WHERE semester = ? AND programme = ? AND section = ? AND day = ? AND period = ?;";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, semester);
            pstmt.setString(2, programme);
            pstmt.setInt(3, section);
            pstmt.setString(4, _day);
            pstmt.setInt(5, _period);
            pstmt.execute();;
            query = "INSERT INTO teacher_routine values (?, ?, ?, ?, ?, ?);";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, semester);
            pstmt.setString(2, programme);
            pstmt.setInt(3, section);
            pstmt.setString(4, _day);
            pstmt.setInt(5, _period);
            pstmt.setString(6, abbv);
            pstmt.executeUpdate();
        }
        @Override
        public String toString(){
            return abbv;
        }
    }
    public class Course{
        private String coursecode;
        private int coursecredit;
        Course(String code, int credit){
            coursecode = code;
            coursecredit = credit;
        }
        public int getCoursecredit() {
            return coursecredit;
        }
        public String getCoursecode() {
            return coursecode;
        }


        public void DatabaseAction(String _day, Integer _period) throws SQLException {;
            String query = "DELETE FROM course_routine WHERE semester = ? AND programme = ? AND section = ? AND day = ? AND period = ?;";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, semester);
            pstmt.setString(2, programme);
            pstmt.setInt(3, section);
            pstmt.setString(4, _day);
            pstmt.setInt(5, _period);
            pstmt.execute();;
            query = "INSERT INTO course_routine values (?, ?, ?, ?, ?, ?);";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, semester);
            pstmt.setString(2, programme);
            pstmt.setInt(3, section);
            pstmt.setString(4, _day);
            pstmt.setInt(5, _period);
            pstmt.setString(6, coursecode);
            pstmt.executeUpdate();
        }

        @Override
        public String toString(){
            return coursecode;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/routinify", "root", "1234");
            stmt= connection.createStatement();
            classroomComboBoxFunction(myClassroom1, "Monday", 1);
            classroomComboBoxFunction(myClassroom2, "Monday", 2);
            classroomComboBoxFunction(myClassroom3, "Monday", 3);
            classroomComboBoxFunction(myClassroom4, "Monday", 4);
            classroomComboBoxFunction(myClassroom5, "Monday", 5);
            classroomComboBoxFunction(myClassroom6, "Monday", 6);
            teacherComboBoxFunction(myTeacher1,  "Monday", 1);
            teacherComboBoxFunction(myTeacher2,  "Monday", 2);
            teacherComboBoxFunction(myTeacher3,  "Monday", 3);
            teacherComboBoxFunction(myTeacher4,  "Monday", 4);
            teacherComboBoxFunction(myTeacher5,  "Monday", 5);
            teacherComboBoxFunction(myTeacher6,  "Monday", 6);
            courseComboBoxFunction(myCourse1, "Monday", 1);
            courseComboBoxFunction(myCourse2, "Monday", 2);
            courseComboBoxFunction(myCourse3, "Monday", 3);
            courseComboBoxFunction(myCourse4, "Monday", 4);
            courseComboBoxFunction(myCourse5, "Monday", 5);
            courseComboBoxFunction(myCourse6, "Monday", 6);
            myClassroom1.setOnAction(e -> classroomEffect(myClassroom1, "Monday", 1));
            myClassroom2.setOnAction(e -> classroomEffect(myClassroom2, "Monday", 2));
            myClassroom3.setOnAction(e -> classroomEffect(myClassroom1, "Monday", 3));
            myClassroom4.setOnAction(e -> classroomEffect(myClassroom2, "Monday", 4));
            myClassroom5.setOnAction(e -> classroomEffect(myClassroom1, "Monday", 5));
            myClassroom6.setOnAction(e -> classroomEffect(myClassroom2, "Monday", 6));
            myTeacher1.setOnAction(e -> teacherEffect(myTeacher1, "Monday", 1));
            myTeacher2.setOnAction(e -> teacherEffect(myTeacher2, "Monday", 2));
            myTeacher3.setOnAction(e -> teacherEffect(myTeacher3, "Monday", 3));
            myTeacher4.setOnAction(e -> teacherEffect(myTeacher4, "Monday", 4));
            myTeacher5.setOnAction(e -> teacherEffect(myTeacher5, "Monday", 5));
            myTeacher6.setOnAction(e -> teacherEffect(myTeacher6, "Monday", 6));
            myCourse1.setOnAction(e -> courseEffect(myCourse1, "Monday", 1));
            myCourse2.setOnAction(e -> courseEffect(myCourse2, "Monday", 2));
            myCourse3.setOnAction(e -> courseEffect(myCourse3, "Monday", 3));
            myCourse4.setOnAction(e -> courseEffect(myCourse4, "Monday", 4));
            myCourse5.setOnAction(e -> courseEffect(myCourse5, "Monday", 5));
            myCourse6.setOnAction(e -> courseEffect(myCourse6, "Monday", 6));


        } catch (SQLException event) {
            throw new RuntimeException(event);
        }


    }



    @FXML
    protected void onClickBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SemesterController.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
