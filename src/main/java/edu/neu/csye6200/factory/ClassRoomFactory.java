/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.factory;
import edu.neu.csye6200.model.ClassRoom;

/**
 *
 * @author gokuljayavel
 */

//eagar singleton
public class ClassRoomFactory {
    private static ClassRoomFactory ele = new ClassRoomFactory();

		private ClassRoomFactory() {

		}

		public static ClassRoomFactory getInstance() {
			return ele;
		}
        public ClassRoom getObject(){
            
            return new ClassRoom();
            
        }
}
