package com.tutorial.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tutorial.mapping.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	
	
	@Query(
			value = "Select * from tbl_student where age>:age",
			nativeQuery = true
			)
	
  public List<Student> getAllStudentAgeAbove(@Param("age") String age);

}
