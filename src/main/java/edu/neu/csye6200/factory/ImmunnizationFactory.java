/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;

import java.time.LocalDate;
import edu.neu.csye6200.model.Imunnization;

/**
 *
 * @author gokuljayavel
 */
public class ImmunnizationFactory {
    
    private static ImmunnizationFactory ele = new ImmunnizationFactory();

		private ImmunnizationFactory() {

		}

		public static ImmunnizationFactory getInstance() {
			return ele;
		}
                
                public Imunnization getObjet(String nextDueDate, int studentid, String vaccinate){
                    return new Imunnization( nextDueDate,  studentid,  vaccinate);
                }
                
}
    
