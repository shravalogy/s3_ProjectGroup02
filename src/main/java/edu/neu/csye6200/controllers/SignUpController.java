/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controllers;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.Auth;
import edu.neu.csye6200.model.Registration;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 *
 * @author dhruvparthasarathy
 */
public class SignUpController {
    
    public static boolean signUp(String userName, char[] password, String userType){
        
        try {

            DB db = DB.getObj();


            PreparedStatement statement = db.conn.prepareStatement(Auth.registerNewUserQuery());
            statement.setString(1, userName);
            statement.setString(2, new String(password));
            statement.setString(3, userType);

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Creating user failed, no rows affected.");
            }else{
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
