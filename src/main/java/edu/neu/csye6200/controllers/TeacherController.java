/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controllers;

import java.sql.*;
import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.Parent;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.model.Teacher;
import edu.neu.csye6200.model.Teacher;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TeacherController {

    private Boolean teacherFlag=false;

    public TeacherController() {
    }
    
    public Boolean getTeacherFlag() {
        return teacherFlag;
    }

    public void setTeacherFlag(Boolean teacherFlag) {
        this.teacherFlag = teacherFlag;
    }
    
    public ResultSet  viewTeachers() {

        
        
        try {
             DB db = DB.getObj();
            Connection conn = db.conn;
            PreparedStatement stmt = conn.prepareStatement("select * from teacher");
            Vector columnNames = new Vector();
            Vector data = new Vector();
            ResultSet rs = stmt.executeQuery();
                JTable jtable = new JTable(buildTableModel(rs));
             JOptionPane.showMessageDialog(null, new JScrollPane(jtable));
           
             
        } catch (Exception e) {
            System.out.print(e.toString());
        }
           return null; 
        }

    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    public boolean register(Teacher teacher) {

        try {
            DB db = DB.getObj();
            Connection conn = db.conn;
            PreparedStatement stmt = conn.prepareStatement("Insert into teacher(fname,lname,emp_phone_no,emp_address,class_id) values(?,?,?,?,?)");
            stmt.setString(1, teacher.getFname());
            stmt.setString(2, teacher.getLname());
            stmt.setString(3, teacher.getPhoneNo());
            stmt.setString(4, teacher.getAddress());
            stmt.setInt(5, teacher.getClassId());
            Boolean executed = stmt.execute();
            if (executed) {
                System.out.println("Error");
                return false;
            } else {
                System.out.println("Record inserted");
                PreparedStatement update = conn.prepareStatement("update classroom set teachersAssigned = teachersAssigned + 1 where class_id = ?");
                update.setInt(1, teacher.getClassId());
                update.execute();
                return true;
            }
           
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return false;
    }
    public void updateTeacher(int employeeID, String firstName, String lastName,
            int classID, String address, String phone, double rating) throws InterruptedException {

        DB db = DB.getObj();

        Teacher t = new Teacher(employeeID, firstName, lastName, address, phone, classID,rating);

        db.update(t.updateTeacherTable());

    }
    public boolean updateClass(String fname,int classId) {

        try {
            DB db = DB.getObj();
            Connection conn = db.conn;
            PreparedStatement stmt = conn.prepareStatement(Teacher.updateclassId());
            stmt.setInt(1, classId);
            stmt.setString(2, fname);
            Boolean executed = stmt.execute();
            if (executed) {
                System.out.println("Error");
                return false;
            } else {
                System.out.println("Record inserted");
                PreparedStatement update = conn.prepareStatement("update classroom set studentsEnrolled = studentsEnrolled + 1 where class_id = ?");
                update.setInt(1, classId);
                update.execute();
                return true;
            }
           
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return false;
    }
     public static List<String> getTeacherList(){
        List<String> list = new ArrayList<>();
         DB db = DB.getObj();

        try {
            PreparedStatement statement = db.conn.prepareStatement(Teacher.getListOfTeachers());
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
 
            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    list.add(rs.getString(i)); //Print one element of a row

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void delete(Teacher teacher) {

        try {
             DB db = DB.getObj();
            Connection conn = db.conn;
            if(teacher.getEmployeeId()!=0){
                PreparedStatement deleteByEmployeeID = conn.prepareStatement("DELETE FROM teacher WHERE employee_id=?");
            deleteByEmployeeID.setString(1,String.valueOf(teacher.getEmployeeId()));
            Boolean executed = deleteByEmployeeID.execute();
            if (executed) {
                System.out.println("Error");
            } else {
                System.out.println("Record deleted");
            }
            
            }
            
           
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
    public void update(Teacher teacher) {

        try {
             DB db = DB.getObj();
            Connection conn = db.conn;
            PreparedStatement updateFirstName=conn.prepareStatement("UPDATE teacher SET fname=? WHERE employee_id=?");
            PreparedStatement updateLastName=conn.prepareStatement("UPDATE teacher SET lname=? WHERE employee_id=?");
            PreparedStatement updatephoneNumber=conn.prepareStatement("UPDATE teacher SET emp_phone_no=? WHERE employee_id=?");
            PreparedStatement updateAddress=conn.prepareStatement("UPDATE teacher SET emp_address=? WHERE employee_id=?");
            PreparedStatement updateRating=conn.prepareStatement("UPDATE teacher SET emp_ratings=? WHERE employee_id=?");
            if(teacher.getEmployeeId()!=0){
                if (teacher.getFname().length()!=0) {
                    updateFirstName.setString(1, teacher.getFname());
                    updateFirstName.setString(2, String.valueOf(teacher.getEmployeeId()));
                    Boolean executed = updateFirstName.execute();
                    if (executed) {
                        System.out.println("Error");
                    } else {
                        System.out.println("updated firstname");
                    }
                }
                if (teacher.getLname().length()!=0) {
                    updateLastName.setString(1, teacher.getLname());
                    updateLastName.setString(2, String.valueOf(teacher.getEmployeeId()));
                    Boolean executed = updateLastName.execute();
                    if (executed) {
                        System.out.println("Error");
                    } else {
                        System.out.println("updated lastname");
                    }
                }
                if (teacher.getPhoneNo().length()!=0) {
                    updatephoneNumber.setString(1, teacher.getPhoneNo());
                    updatephoneNumber.setString(2, String.valueOf(teacher.getEmployeeId()));
                    Boolean executed = updatephoneNumber.execute();
                    if (executed) {
                        System.out.println("Error");
                    } else {
                        System.out.println("updated phonenumber");
                    }
                }
                if (teacher.getAddress().length()!=0) {
                    updateAddress.setString(1, teacher.getAddress());
                    updateAddress.setString(2, String.valueOf(teacher.getEmployeeId()));
                    Boolean executed = updateAddress.execute();
                    if (executed) {
                        System.out.println("Error");
                    } else {
                        System.out.println("updated address");
                    }
                }
                if (teacher.getRating() != 0.0 ) {
                    updateRating.setString(1, String.valueOf(teacher.getRating()));
                    updateRating.setString(2, String.valueOf(teacher.getEmployeeId()));
                    Boolean executed = updateRating.execute();
                    if (executed) {
                        System.out.println("Error");
                    } else {
                        System.out.println("updated rating");
                    }
                }
            }     
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
    
    
   
}
