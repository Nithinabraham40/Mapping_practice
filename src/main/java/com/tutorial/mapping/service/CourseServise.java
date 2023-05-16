package com.tutorial.mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.mapping.dao.CourseDao;
import com.tutorial.mapping.model.Course;
import com.tutorial.mapping.repository.CourseRepository;
@Service
public class CourseServise {
	
	
	
	@Autowired
	private CourseRepository courseRepo;

	public ResponseEntity<String> addCourses(CourseDao courseDao) {
		
		Course course=new Course();
		
		course.setDescription(courseDao.getDescription());
		course.setDuration(courseDao.getDuration());
		course.setTitle(courseDao.getTitle());
		
		courseRepo.save(course);
		
		return new ResponseEntity<String>("sucessfully Added",HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteCourseById(Long id) {
	
		
		courseRepo.deleteById(id);
		return new ResponseEntity<String>("sucessfully Deleted",HttpStatus.OK);
	}

	

}
