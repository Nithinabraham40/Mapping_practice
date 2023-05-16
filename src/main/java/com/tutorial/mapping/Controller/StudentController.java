package com.tutorial.mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.mapping.model.Book;
import com.tutorial.mapping.model.Laptop;
import com.tutorial.mapping.model.Student;
import com.tutorial.mapping.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/add")
	public ResponseEntity<String>addStrudent(@RequestBody Student student){
		
		
		return studentService.addStudent(student);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Student>>getAllStudentAgeAbove(@RequestParam("ageabove") String age){
		
		
		return studentService.getAllStudentAgeAbove(age);
		
		
		
	}
	
	@PutMapping("/update/id/{id}")
	
	public ResponseEntity<String>updatelandmarkWhereStudentId(@PathVariable("id")Long id,@RequestParam("landmark") String landmark)
	{
		
		return studentService.updatelandmarkWhereStudentId(id,landmark);
	}
	
	@GetMapping("/get/laptop/id/{id}")
	
	public ResponseEntity<Laptop>getTheLaptopDetailsForStudent(@PathVariable Long id){
		
		
		return studentService.getTheLaptopDetailsForStudent(id);
		
	}
	
	@GetMapping ("see/allBooks")
	
	public ResponseEntity<List<Book>>seeAllBooks(){
		
		
		return studentService.seeAllBooks();
	}
	
	@PostMapping("book/studentid/{id}/added")
	
	public ResponseEntity<String>studentSelectBooksById(@PathVariable Long id, @RequestParam("bookids") List<Long>allIds){
		
		
		return studentService.studentSelectBooksById(id,allIds);
		
	}
	@PostMapping("add/course/studentid/{id}")
	
	public ResponseEntity<String>addTheSelectedCoursesToStudent(@PathVariable("id")Long id ,@RequestParam("courseids")List<Long>allIds ){
		
		
		return studentService.addTheSelectedCoursesToStudent(id,allIds);
	}
	
	
	
	

}
