package com.tutorial.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.mapping.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	
	
//	@Query(
//			value="select * from tbl_book where fk_student_student_id=:studentId",
//			
//			nativeQuery = true
//			
//			)
//	
//	
//	Book findbyFk(Long studentId);

}
