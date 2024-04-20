/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.model;

/**
 *
 * @author dhruvparthasarathy
 */
public class Auth {
    
    // We have an auth object as it will store the details of the user who is authenticated
    private static Auth instance;
    private static String userName;
    private static String userType;
    
    
    public static String getPasswordAndTypeQuery(String userName) {
        String query = "SELECT password, user_type FROM auth WHERE user_name='" + userName + "';";
            return query;
    }
    
    public static String registerNewUserQuery(){
        return "INSERT INTO auth (user_name, password, user_type) VALUES(?,?,?);";
    }
    
    
    public static void setUserName(String uName){
        userName = uName;
    }
    

    public static void setUserType(String uType){
        userType = uType;
    }
    
    public static String getUserType(){
        return userType;
    }
    
    public static void logOut(){
        userName = null;
        userType = null;
    }
    
}
