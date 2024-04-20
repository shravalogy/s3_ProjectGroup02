/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controllers;


import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.Auth;
import edu.neu.csye6200.model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dhruvparthasarathy
 */
public class SignInController {
//    private static SignInController controller;
//    
//    
//    public static SignInController getObj() {
//        if (controller == null) {
//            controller = new SignInController();
//        }
//        return controller;
//    }
    
    public static boolean isLoginValid(String userName, char[] passwordArr){
        List<String> list = new ArrayList<>();
         DB db = DB.getObj();

        try {
            PreparedStatement statement = db.conn.prepareStatement(Auth.getPasswordAndTypeQuery(userName));
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
 
            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    list.add(rs.getString(i)); //Print one element of a row

                }
            }
            
            if(list.isEmpty()){
                return false;
            } else {
                String pass = list.get(0);
                String userType = list.get(1);
                String inputPass = new String(passwordArr);
                boolean isValid = pass.equals(inputPass);
                
                if(isValid){
                    // set the user type in the auth class
                    Auth.setUserType(userType);   
                    Auth.setUserName(userName);
                } else {
                    Auth.setUserType(null);   
                    Auth.setUserName(null);
                }
                
                return isValid;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
}
