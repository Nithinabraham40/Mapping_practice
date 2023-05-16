package com.tutorial.mapping.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDao {

	
	private String title;
	private String description;
	private String duration;
}
