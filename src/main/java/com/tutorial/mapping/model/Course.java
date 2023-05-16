package com.tutorial.mapping.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_course")
public class Course {

	
	@Id
	@SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1,initialValue = 8000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_sequence")
	private Long CourseId;
	private String title;
	private String description;
	private String duration;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Course_student",joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
	List<Student> studentList;
	
}
