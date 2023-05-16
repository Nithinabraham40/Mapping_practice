package com.tutorial.mapping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.mapping.model.Laptop;
import com.tutorial.mapping.model.Student;
import com.tutorial.mapping.repository.LaptopRepo;
import com.tutorial.mapping.repository.StudentRepo;


@Service
public class LaptopService {
	
	
	
	@Autowired
	private LaptopRepo laptopRepo;
	
	@Autowired StudentRepo studentRepo;

	public ResponseEntity<String> addLaptop(Laptop laptop) {
		
		Long studentId=laptop.getStudent().getStudentID();
		
		Optional<Student> findStudent=studentRepo.findById(studentId);
		
		if(!findStudent.isPresent()) {
			
			return new ResponseEntity<String>("Give a valid studentid",HttpStatus.BAD_REQUEST);
		}
		
		laptop.setStudent(findStudent.get());
		
		laptopRepo.save(laptop);
		
		
		return new ResponseEntity<String>("Saved the details",HttpStatus.OK);
	}

	public ResponseEntity<String> deleteLaptopWithId(Long id) {
	
		Optional<Laptop> findLaptop=laptopRepo.findById(id);
		
		if(!findLaptop.isPresent()) {
			return new ResponseEntity<String>("Give a valid id",HttpStatus.BAD_REQUEST);
		}
		
		laptopRepo.delete(findLaptop.get());
		
		return new ResponseEntity<String>("Deleted sucessfully",HttpStatus.OK);
	}

}
