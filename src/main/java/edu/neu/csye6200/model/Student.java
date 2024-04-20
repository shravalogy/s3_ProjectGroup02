/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.model;

import java.util.ArrayList;
import java.util.List;


public class Student {

	private int studentId;
	private int parentId;
	private String studentName;
	private int age;
	private String dateofBirth;
	
        private int classId;
        
        

	{
		studentId = -1;
		studentName = "";
		age = -1;
		dateofBirth = "";
		

	}

	public Student(int studentId, String studentName, int age, String dateofBirth) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.dateofBirth = dateofBirth;
	}

	public Student(String studentName, String dateOfBirth, int age) {
		super();
		this.studentName = studentName;
		this.dateofBirth = dateOfBirth;
		this.age = age;

	}
        
        public Student(int studentId, String studentName, String dateofBirth) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateofBirth = dateofBirth;
		
	}
        
        public Student(int studentId, int classId){
            super();
		this.studentId = studentId;
                this.classId=classId;
        }
        
        
        

	public Student() {
		super();

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String generateRegisterQuery() {
		return "INSERT INTO student (name, dob, age,parent_id) VALUES(?,?,?,?);";
	}

	public String generateStudentIdQuery() {
		return "SELECT student_id FROM student WHERE name=" + this.studentName;
	}
        
        public String updateStudentTable(){
                return "UPDATE student SET " +
                         " name = " +"'"+this.studentName+"'"+
                        ", dob = " +"'"+ this.dateofBirth +"'"+
                        ", age= " +"'"+ this.age +  "'"+
                        " WHERE student_id =" +"'"+ this.studentId + "'"+";";
        }
        
        public String showStudentTable(){
            return "SELECT s.student_id,s.name,s.age,s.dob,s.parent_id,p.name,p.address,p.phone "
                    + " FROM student s,parent p;";
        }
 
        public String updateStudentClass(){
                return "UPDATE student SET " +
                         " class_id = " +"'"+this.classId+"'"+
                        " WHERE student_id =" +"'"+ this.studentId + "'"+";";
        }
        public static String getUnAssignedStudents(){
            return "select student_id from student where class_id IS NULL";
        }
        public static String getAllStudents(){
            return "select student_id from student";
        }
       
}
