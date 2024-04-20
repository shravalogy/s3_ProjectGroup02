/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controllers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Period;
import java.util.Currency;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.Parent;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.factory.ParentFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentController {

    private static StudentController studentController;
    
    private int getAgeFromDOB(LocalDate dob) {
        return Period.between(dob, new Date(System.currentTimeMillis()).toLocalDate()).getYears();
    }

    private int getAgeFromDOB2(Date dob) {
        
        return Period.between(dob.toLocalDate(), new Date(System.currentTimeMillis()).toLocalDate()).getYears();
    }


    public boolean addStudentAndParent(String name, String dob, String parentName, String parentPhone,
            String parentAddress,String email) {
         boolean status = false;
        try {

            DB db = DB.getObj();

            Date dobFromString = Date.valueOf(dob);

            int age = getAgeFromDOB2(dobFromString);
            System.out.print(age);
            // create student obj
            Student s = new Student(name, dobFromString.toString(), age);
            Parent p = new Parent(parentName, parentAddress, parentPhone,email);
            
            Parent p1 = ParentFactory.getInstance().getObject(parentName, parentAddress, parentPhone, email);

            PreparedStatement statement = db.conn.prepareStatement(p.generateRegisterQuery(),
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getParentName());
            statement.setString(2, p.getParentAddress());
            statement.setString(3, p.getParentPhoneNo());
            statement.setString(4, p.getEmail());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Creating user failed, no rows affected.");
            }

            int parentId = -1;
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    parentId = rs.getInt(1);
                }
                rs.close();
            }
            // db.query(p.generateRegisterQuery());
            // int parentId = db.getGeneratedKey();

            s.setParentId(parentId);

            statement = db.conn.prepareStatement(s.generateRegisterQuery(), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, s.getStudentName());
            statement.setString(2, s.getDateofBirth());
            statement.setInt(3, s.getAge());
            statement.setInt(4, s.getParentId());

            affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Creating user failed, no rows affected.");
            }

            int student_id = -1;
            try (ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    student_id = rs.getInt(1);
                }
                rs.close();
            }

            status = RegistrationController.getObj().addStudent(student_id);

            // db.query(s.generateRegisterQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static List<Integer> getUnAssignedStudents(){
        List<Integer> list = new ArrayList<>();
         DB db = DB.getObj();

        try {
            PreparedStatement statement = db.conn.prepareStatement(Student.getUnAssignedStudents());
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
 
            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    list.add(rs.getInt(i)); //Print one element of a row

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static List<Integer> getAllStudents(){
        List<Integer> list = new ArrayList<>();
         DB db = DB.getObj();

        try {
            PreparedStatement statement = db.conn.prepareStatement(Student.getAllStudents());
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
 
            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    list.add(rs.getInt(i)); //Print one element of a row

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       
               
    

    public static StudentController getObj() {
        if (studentController == null) {
            studentController = new StudentController();
        }
        return studentController;
    }

    public void updateStudentAndParent(int studentId, String studentName, String dateofBirth,
            int parentId, String parentName, String parentAddress, String parentPhoneNo,String email) throws InterruptedException {

        DB db = DB.getObj();



        Date dob = Date.valueOf(dateofBirth);

        int age = getAgeFromDOB2(dob);
        Student s = new Student(studentId, studentName, dob.toString());
        Parent p = new Parent(parentId,parentName, parentAddress, parentPhoneNo,email);

        s.setAge(age);

        db.update(s.updateStudentTable());
        Thread.sleep(200);
        db.update(p.updateParentTable());



    }

    public void showStudentAndParentTable(int studentId, String studentName, String dateofBirth,
            int parentId, String parentName, String parentAddress, String parentPhoneNo,String email) {

        DB db = DB.getObj();

        Date dob = Date.valueOf(dateofBirth);

        int age = getAgeFromDOB2(dob);
        Student s = new Student(studentId, studentName, dob.toString());
        Parent p = new Parent(parentId,parentName, parentAddress, parentPhoneNo,email);

        s.setAge(age);

        db.query(s.showStudentTable());

        // PreparedStatement insert =
        // ResultSetMetaData rss =


    }
    
    public void UpdateStudentClass(int studentId, int classId){
        DB db = DB.getObj();
        Student s = new Student(studentId,classId);
//        Teacher t = new Teacher(teacherName,classId);
        db.update(s.updateStudentClass());
//        db.update(t.updateStudentTeacher());
        
    }


}
