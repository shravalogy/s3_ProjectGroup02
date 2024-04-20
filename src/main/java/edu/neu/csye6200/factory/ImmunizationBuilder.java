/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.Imunnization;
/**
 *
 * @author gokuljayavel
 */

//builder design pattern
public class ImmunizationBuilder {

    private String svid;
    private String nextDueDate;
    private int studentid;
    private String vaccinate;

    public ImmunizationBuilder() {
        this.svid = null;
        this.nextDueDate = null;
        this.studentid = 0;
        this.vaccinate = null;

    }
    
    public ImmunizationBuilder setSvid(String svid){
        this.svid = svid;
        return this;
    }
    
    public ImmunizationBuilder setnextDueDate(String nextDueDate){
        this.nextDueDate = nextDueDate;
        return this;
    }
    public ImmunizationBuilder setStudentid(int studentid){
        this.studentid = studentid;
        return this;
    }
    
    public ImmunizationBuilder setVaccinate(String vaccinate){
        this.vaccinate = vaccinate;
        return  this;
    }
    
    public Imunnization build(){
    return new Imunnization(nextDueDate, studentid, vaccinate);
    }

}
