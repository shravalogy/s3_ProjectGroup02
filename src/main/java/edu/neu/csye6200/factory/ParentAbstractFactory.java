/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.Parent;

/**
 *
 * @author gokuljayavel
 */
public interface ParentAbstractFactory {
    
    public abstract Parent getObject(String parentName, String parentAddress, String parentPhoneNo,String email);
    
}
