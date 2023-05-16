package com.tutorial.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.mapping.dao.LaptopDao;
import com.tutorial.mapping.dao.StudentDao;
import com.tutorial.mapping.model.Address;
import com.tutorial.mapping.model.Book;
import com.tutorial.mapping.model.Course;
import com.tutorial.mapping.model.Laptop;
import com.tutorial.mapping.model.Student;
import com.tutorial.mapping.repository.AddressRepo;
import com.tutorial.mapping.repository.BookRepository;
import com.tutorial.mapping.repository.CourseRepository;
import com.tutorial.mapping.repository.LaptopRepo;
import com.tutorial.mapping.repository.StudentRepo;



@Service
public class StudentService {

	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private LaptopRepo laptopRepo;
	
	@Autowired
	private BookRepository  bookRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	public ResponseEntity<String> addStudent(Student student) {
	
		Address address=student.getAddress();
		
		addressRepo.save(address);
		studentRepo.save(student);
	
		return new ResponseEntity<String>("Added the details",HttpStatus.ACCEPTED);
	}
	
	

	public ResponseEntity<List<StudentDao>> getAllStudentAgeAbove(String age) {
		
		
		List<Student>allstudent= studentRepo.getAllStudentAgeAbove(age);
		List<StudentDao>allStudentDao=new ArrayList<>();
		if(allstudent==null) {
			
			return new ResponseEntity<List<StudentDao>>(allStudentDao,HttpStatus.NO_CONTENT);
		}
		for(Student student:allstudent) {
			
			StudentDao studentDao=new StudentDao();
			studentDao.setName(student.getName());
			studentDao.setBranch(student.getBranch());
			studentDao.setDepartment(student.getDepartment());
			studentDao.setPhoneNumber(student.getPhoneNumber());
			studentDao.setAge(student.getAge());
			allStudentDao.add(studentDao);
			
		}
		
		
		return new ResponseEntity<List<StudentDao>>(allStudentDao,HttpStatus.FOUND);
	}
	
	
	

	public ResponseEntity<String> updatelandmarkWhereStudentId(Long id, String landmark) {
		
		Optional<Student> findStudent=studentRepo.findById(id);
		
		if(findStudent.get()==null) {
			
			return new ResponseEntity<String>("give valid id",HttpStatus.NO_CONTENT);
		}
		
		Long addressId=findStudent.get().getAddress().getAddressId();
		
		addressRepo.updatelandmark(addressId,landmark);
		
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
	
	
	

	public ResponseEntity<LaptopDao> getTheLaptopDetailsForStudent(Long id) {
		
		LaptopDao laptopDao=new LaptopDao();
		Laptop laptop= laptopRepo.getTheLaptopDetailsForStudent(id);
		
		if(laptop==null) {
			
			return new ResponseEntity<LaptopDao>(laptopDao,HttpStatus.NO_CONTENT);
		}
		
		laptopDao.setLaptopBrand(laptop.getLaptopBrand());
		laptopDao.setLaptopName(laptop.getLaptopName());
		laptopDao.setLaptopPrice(laptop.getLaptopPrice());
		return new ResponseEntity<LaptopDao>(laptopDao,HttpStatus.OK);
	}
	
	
	
	

	public ResponseEntity<List<Book>> seeAllBooks() {
		
		List<Book>allBooksInBookrepo=bookRepo.findAll();
		
		
		return new ResponseEntity<List<Book>>(allBooksInBookrepo,HttpStatus.FOUND);
	}
	
	
	

	public ResponseEntity<String> studentSelectBooksById(Long studentId,List<Long> allIds) {
		
		
		for(Long id:allIds) {
			
			Optional<Book> findBook=bookRepo.findById(id);
			if(!findBook.isPresent()) {
				
				return new ResponseEntity<String>("This Id "+id+"is not valid",HttpStatus.BAD_REQUEST);
				
			}
			//to check the book is assigned or not
			
			if(findBook.get().getStudent()!=null) {
				
				return new ResponseEntity<String>("This book is already assigned",HttpStatus.BAD_REQUEST);
			}
			
			
			
				
				Student student=studentRepo.findById(studentId).get();
				
				findBook.get().setStudent(student);
				
				bookRepo.save(findBook.get());
			
			
			
			
				
				
			
			
		}
		
		
		return new ResponseEntity<String>("Sucessfully assigned!!",HttpStatus.OK);
	}



	public ResponseEntity<String> addTheSelectedCoursesToStudent(Long studentId, List<Long> allIds) {
		
		Course thisCourse=new Course();
	
		for(Long id:allIds) {
			
		Optional<Course>findCourse=courseRepo.findById(id);
		
		if(!findCourse.isPresent()) {
			
			return new ResponseEntity<String>("This Id "+id+"is not valid",HttpStatus.BAD_REQUEST);
			
		}
		
		Student student=studentRepo.findById(studentId).get();
		
	List<Student>addstudents=new ArrayList<>();
	
	addstudents.add(student);
	
	thisCourse=findCourse.get();
	
	thisCourse.setStudentList(addstudents);
			
		}
		
		
		
		courseRepo.save(thisCourse);
		
		return new ResponseEntity<String>("Course assigned sucessfully",HttpStatus.OK);
		
		
		
	}

}
