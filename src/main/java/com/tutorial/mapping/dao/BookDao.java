package com.tutorial.mapping.dao;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDao {

	
	private String title;
	private String author;
	private String description;
	private String price;
}
