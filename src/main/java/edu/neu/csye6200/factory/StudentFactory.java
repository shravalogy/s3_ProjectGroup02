/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.Student;
/**
 *
 * @author gokuljayavel
 */
public class StudentFactory {
     private static StudentFactory ele;

    private StudentFactory() {

    }

    public static StudentFactory getInstance() {
        if (ele == null) {
            ele = new StudentFactory();
        }
        return ele;
    }
    
    public Student getObject(){
        return new Student();
    }
    
    public Student getObject(int studentId, int classId){
        return new Student(studentId, classId);
    }
    
    public Student getObject(int studentId, String studentName, String dateofBirth){
        return new Student(studentId, studentName, dateofBirth);
    }
    
    public Student getObject(String studentName, String dateOfBirth, int age){
        return new Student(studentName, dateOfBirth, age);
    }
    
    public Student getObject(int studentId, String studentName, int age, String dateofBirth ){
        return new Student(studentId, studentName, age, dateofBirth);
    }
    
    
}
