/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.model;

import edu.neu.csye6200.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tarun
 */
public class ClassRoom {

    private int ClassID;
    private int studentCapacity;
    private int studentEnrolled;
    private int minAge;
    private int maxAge;
    private int teacherCapacity;
    private int teachersAssigned;

    public int getClassID() {
        return ClassID;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public int getStudentEnrolled() {
        return studentEnrolled;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getTeacherCapacity() {
        return teacherCapacity;
    }

    public int getTeachersAssigned() {
        return teachersAssigned;
    }

    public void setClassID(int ClassID) {
        this.ClassID = ClassID;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public void setStudentEnrolled(int studentEnrolled) {
        this.studentEnrolled = studentEnrolled;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public void setTeacherCapacity(int teacherCapacity) {
        this.teacherCapacity = teacherCapacity;
    }

    public void setTeachersAssigned(int teachersAssigned) {
        this.teachersAssigned = teachersAssigned;
    }

    public List<Integer> getClassList(int student_id) {
        DB db = DB.getObj();
        List<Integer> classes = new ArrayList<>();
        try {
            
            PreparedStatement statement = db.conn.prepareStatement("select c.class_id  from classroom c,student s where studentCapacity > studentsEnrolled and s.age >= minAge and s.age<=maxAge and s.student_id="+student_id);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
 
            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    classes.add(rs.getInt(i)); //Print one element of a row

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }
    public List<Integer> getallClassList() {
        DB db = DB.getObj();
        List<Integer> classes = new ArrayList<>();
        try {
            PreparedStatement statement = db.conn.prepareStatement("select class_id  from classroom");
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
 
            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    classes.add(rs.getInt(i)); //Print one element of a row

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return classes;
    }

}
