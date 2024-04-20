/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.Teacher;

/**
 *
 * @author gokuljayavel
 */
public class TeacherFactory {
    private static TeacherFactory ele;

    private TeacherFactory() {

    }

    public static TeacherFactory getInstance() {
        if (ele == null) {
            ele = new TeacherFactory();
        }
        return ele;
    }
    
    public Teacher getObject(){
        return new Teacher();
    }
    
    public Teacher getObject(String fname, String lname, String address, String phoneNo, int classId){
        return new Teacher(fname, lname, address, phoneNo, classId);
    }
    
    public Teacher getObject(int employeeID,String fname, String lname, String address, String phoneNo, int classId,Double rating){
        return new Teacher(employeeID, fname, lname, address, phoneNo, classId, rating);
    }
    
}
