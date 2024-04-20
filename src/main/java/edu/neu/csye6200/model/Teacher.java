/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.model;

/**
 *
 * @author Tarun
 */
public class Teacher {

    
    
    protected int employeeId;
    protected String fname;
    protected String lname;
    protected String address;
    protected String phoneNo;
    protected Double rating;
    protected int classId;

    public Teacher(){}

    public Teacher(String fname, String lname, String address, String phoneNo, int classId) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNo = phoneNo;
        this.classId = classId;
    }
    public Teacher(int employeeID,String fname, String lname, String address, String phoneNo, int classId,Double rating) {
        this.fname = fname;
        this.lname = lname;
        this.employeeId = employeeID;
        this.address = address;
        this.phoneNo = phoneNo;
        this.classId = classId;
        this.rating = rating;
    }
    

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
    
    
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getEmployeeId() {
        return employeeId;
    }


    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public Double getRating() {
        return rating;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    public String updateStudentTeacher(){
            return "UPDATE teacher SET " +
                         " class_id = " +"'"+this.classId+"'"+
                        " WHERE class_id =" +"'"+ this.classId + "'"+";";
        }
    public static String getListOfTeachers(){
            return "select fname from teacher";
        }
    public static String updateclassId(){
        return "update teacher set class_id = ? where fname = ?";
    }
    public String updateTeacherTable(){
                return "UPDATE teacher SET " +
                         " fname = " +"'"+this.fname+"'"+
                        ", lname = " +"'"+ this.lname +"'"+
                        ", emp_phone_no = " +"'"+ this.phoneNo +  "'"+
                         ", emp_address = " +"'"+ this.address +  "'"+
                         ", class_id = " +"'"+ this.classId +  "'"+
                         ", emp_ratings = " +"'"+ this.rating +  "'"+
                        " WHERE employee_id =" +"'"+ this.employeeId + "'"+";";
        }
    
}
