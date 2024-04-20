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
//lazy singleton
public class ParentFactory implements ParentAbstractFactory{

    private static ParentFactory ele;

    private ParentFactory() {

    }

    public static ParentFactory getInstance() {
        if (ele == null) {
            ele = new ParentFactory();
        }
        return ele;
    }
    @Override
    public Parent getObject(String parentName, String parentAddress, String parentPhoneNo,String email){
        return new Parent( parentName,  parentAddress,  parentPhoneNo, email);
    }
    
    public Parent getObject(int parentId, String parentName, String parentAddress, String parentPhoneNo,String email){
        return new Parent( parentId,  parentName,  parentAddress,  parentPhoneNo, email);
    }

}
