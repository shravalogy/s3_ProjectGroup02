/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.controllers;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.Imunnization;
import edu.neu.csye6200.model.Registration;
import edu.neu.csye6200.utils.sendMail;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.neu.csye6200.factory.ImmunizationBuilder;

/**
 *
 * @author premkumarmanoharan
 */
public class ImmunizationController {

    public boolean addImmunization(String vaccinate, String nextDate, int student_id) {
        try {
            Date next = null;
            DB db = DB.getObj();
            if (nextDate != null) {
                next = Date.valueOf(nextDate);
            }
           // Imunnization imu = new Imunnization(nextDate, student_id, vaccinate);
            Imunnization imu = new ImmunizationBuilder().setStudentid(student_id).setnextDueDate(nextDate).setVaccinate(vaccinate).build();
            
            
            PreparedStatement statement = db.conn.prepareStatement(imu.getAddImmuQuery());
            statement.setDate(1, next);
            statement.setInt(2, imu.getstudentid());
            statement.setString(3, imu.getVaccinate());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Creating user failed, no rows affected.");
            } else {
                return true;
            }

        } catch (Exception e) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean sendMail() {
        try {
            DB db = DB.getObj();
            List<Integer> list = new ArrayList<>();
            List<String> email = new ArrayList<>();
            Imunnization imu = new Imunnization();
            PreparedStatement statement = db.conn.prepareStatement(imu.getImmunizationdetail());
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();

            int columnsNumber = rss.getColumnCount();
            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {

                    list.add(rs.getInt(i)); //Print one element of a row

                }
            }
            System.out.println(list);

            for (int i = 0; i < list.size(); i++) {
                PreparedStatement statement_1 = db.conn.prepareStatement(imu.getEmail(list.get(i)));
                ResultSet rst = statement_1.executeQuery();
                ResultSetMetaData rs1 = rst.getMetaData();
                int columnsNumbers = rs1.getColumnCount();
            while (rst.next()) {

                for (int j = 1; j <= columnsNumbers; j++) {
                    sendMail se = new sendMail();
                    se.sendMail(rst.getString(j));

                    email.add(rst.getString(j)); //Print one element of a row

                }
            }
                
            }
            
            System.out.println(email);
            Logger.getLogger(ImmunizationController.class.getName()).log(Level.INFO, null, list);

        } catch (Exception e) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;
    }
}
