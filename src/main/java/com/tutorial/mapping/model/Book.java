package com.tutorial.mapping.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_book")
public class Book {
	
	
	@Id
	@SequenceGenerator(name = "book_sequence",sequenceName = "book_sequence",allocationSize = 1,initialValue = 200)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_sequence")
	private Long ID;

	private String title;
	private String author;
	private String description;
	private String price;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_student_student_id")
	@JsonIgnore

	private Student student;

}
