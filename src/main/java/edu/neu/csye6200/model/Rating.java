/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.model;


public class Rating {
    private int empID;
    private int year;
    private int rating;

    public Rating(int empID, int year, int rating) {
        this.empID = empID;
        this.year = year;
        this.rating = rating;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Rating{" +
                "empID=" + empID +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
    
}
