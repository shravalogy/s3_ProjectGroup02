package edu.neu.csye6200.model;

import java.time.LocalDate;
import java.sql.Date;

public class Registration {
    private int student_id;
    private LocalDate registeredDate;
    private LocalDate renewalDate;
    private int yearsMember;

    public Registration() {
        super();
    }

    public Registration(int student_id) {
        this.student_id = student_id;
    }

    public Registration(int student_id, LocalDate registeredDate, LocalDate renewalDate, int yearsMember) {
        this.student_id = student_id;
        this.registeredDate = registeredDate;
        this.renewalDate = renewalDate;
        this.yearsMember = yearsMember;
    }

    public Registration(int student_id, LocalDate renewalDate, int yearsMember) {
        this.student_id = student_id;
        this.renewalDate = renewalDate;
        this.yearsMember = yearsMember;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Date getRegisteredDate() {
        return Date.valueOf(registeredDate);
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Date getRenewalDate() {
        return Date.valueOf(renewalDate);
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public int getYearsMember() {
        return yearsMember;
    }

    public void setYearsMember(int yearsMember) {
        this.yearsMember = yearsMember;
    }

    public String generateRegisterQuery() {
        return "INSERT INTO registration (student_id,created_date,renewal_date,years_member) VALUES(?,?,?,?);";
    }

    public String generateUpdateQuery() {
        return "Update registration SET renewal_date = DATE_ADD(renewal_date,INTERVAL 1 YEAR),years_member = years_member+1 WHERE student_id = "
                + this.student_id + ";";
    }

}
