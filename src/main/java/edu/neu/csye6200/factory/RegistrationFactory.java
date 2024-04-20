/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.Registration;
import java.time.LocalDate;
/**
 *
 * @author gokuljayavel
 */
public class RegistrationFactory {
    
    private static RegistrationFactory ele;

    private RegistrationFactory() {

    }

    public static RegistrationFactory getInstance() {
        if (ele == null) {
            ele = new RegistrationFactory();
        }
        return ele;
    }
    
    public Registration getObject(int student_id){
        return new Registration(student_id);
    }
    
    public Registration getObject(int student_id, LocalDate registeredDate, LocalDate renewalDate, int yearsMember){
        return new Registration(student_id, registeredDate, renewalDate, yearsMember);
    }
    
    public Registration getObject(int student_id, LocalDate renewalDate, int yearsMember){
        return new Registration(student_id, renewalDate, yearsMember);
    }
    
}
