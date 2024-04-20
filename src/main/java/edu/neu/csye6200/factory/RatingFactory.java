/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.Rating;
/**
 *
 * @author gokuljayavel
 */
public class RatingFactory {
    private static RatingFactory ele;

    private RatingFactory() {

    }

    public static RatingFactory getInstance() {
        if (ele == null) {
            ele = new RatingFactory();
        }
        return ele;
    }
    
    public Rating getObject(int empID, int year, int rating){
        return new Rating( empID,  year,  rating);
    }
    
}
