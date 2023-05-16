package com.tutorial.mapping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.mapping.dao.CourseDao;

import com.tutorial.mapping.service.CourseServise;

@RestController
@RequestMapping("/course")
public class CourseController {

	
	@Autowired
	private CourseServise courseService;
	
	
	@PostMapping("/add")
	
	private ResponseEntity<String>addCourses(@RequestBody CourseDao courseDao){
		
		
		return courseService.addCourses(courseDao);
		
	}
	
	@DeleteMapping("/delete/id/{id}")
	private ResponseEntity<String>deleteCourseById(@PathVariable("id") Long id){
		return courseService.deleteCourseById(id);
		
	}
	
	
}
