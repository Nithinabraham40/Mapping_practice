package com.tutorial.mapping.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_laptop")
public class Laptop {

	@Id
	@SequenceGenerator(name = "laptop_sequence",sequenceName = "laptop_sequence",allocationSize = 1,initialValue = 4000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "laptop_sequence")
	private Long laptopID;
	private String laptopName;
	private String laptopBrand;
	private Integer laptopPrice;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_student_studentId")
	@JsonIgnore
	private Student student;
	
}
