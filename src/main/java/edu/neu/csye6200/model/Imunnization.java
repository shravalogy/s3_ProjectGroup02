package edu.neu.csye6200.model;
import java.sql.*;
import java.util.Date;
import java.time.Month;
import java.time.LocalDate;
import org.joda.time.DateTime;

public class Imunnization extends Student {
    private String svid;
    private String nextDueDate;
    private int studentid;
    private String vaccinate;

    public Imunnization(String nextDueDate, int studentid, String vaccinate) {
        this.nextDueDate = nextDueDate;
        this.studentid = studentid;
        this.vaccinate = vaccinate;
    }
    
    public Imunnization(){
        
    }
    

    public String getSvid() {
        return svid;
    }

    public void setSvid(String svid) {
        this.svid = svid;
    }

    public String getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(String nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public int getstudentid() {
        return studentid;
    }

    public void setstudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getVaccinate() {
        return vaccinate;
    }

    public void setVaccinate(String vaccinate) {
        this.vaccinate = vaccinate;
    }
    public String getAddImmuQuery(){
        return "Insert into immunization_record(next_dose_due_date,student_id,vaccinated) values(?,?,?)";
    } 
    
     public String getImmunizationdetail(){
        DateTime dateTime = new DateTime();
        DateTime after = dateTime.plusDays(15);
       //Ssystem.out.println()
        return "Select student_id from immunization_record WHERE next_dose_due_date  < ('"+after+"')";
    }
    
    public String getEmail(Integer stid){
        
        return "SELECT parent.email FROM parent INNER JOIN student ON parent.parent_id=student.parent_id  WHERE student.student_id = ("+stid+")";
    }

    
}



