package com.tutorial.mapping.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDao {

	private String name;
	private String age;
	private String phoneNumber;
	private String branch;
	private String department;
}
