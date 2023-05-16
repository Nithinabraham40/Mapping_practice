package com.tutorial.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.mapping.model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Long>{

	
	@Query(
			
			value = "select * from tbl_laptop where fk_student_student_id=:id",
			nativeQuery = true
			
			)
public	Laptop getTheLaptopDetailsForStudent(Long id);

	
	
	
	

}
