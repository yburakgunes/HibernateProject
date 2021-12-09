package com.bilgeadam.main;

import com.bilgeadam.controller.StudentController;
import com.bilgeadam.entity.StudentEntity;

public class StudentEntityMain {
	
	public static void main(String[] args) {
		
		// Create
		for (int i = 0; i < 10; i++) {
			
			StudentEntity studentEntity = new StudentEntity("big data " + i, "Burak " + i, "Gunes" + i,
					"yburakgunes@hotmail.com " + i, "passwords" + i, 100 + i);
			StudentController studentController1 = new StudentController();
			studentController1.create(studentEntity);
		}
		
		// find
		// StudentController studentController2 = new StudentController();
		// long id = 1;
		// studentController2.find(id);
		
		// delete
		// StudentController studentController3 = new StudentController();
		// StudentEntity studentEntity2 = new StudentEntity();
		// studentEntity2.setStudentId(2L);
		// studentController3.delete(studentEntity2);
		
		// update
		
		// StudentEntity studentEntity4 = new StudentEntity("YusufBurak123", "Gunes",
		// "yburakgunes", "root");
		// studentEntity4.setStudentId(3);
		// StudentController studentController4 = new StudentController();
		// studentController4.update(studentEntity4);
		
		// list
		StudentController studentController5 = new StudentController();
		
		for (StudentEntity temp : studentController5.list()) {
			System.out.println(temp);
			
		}
		
	}
	
}
