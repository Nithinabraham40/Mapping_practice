package com.tutorial.mapping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_address")
public class Address {
	
	@Id
	@SequenceGenerator(name = "address_sequence",sequenceName = "address_sequence",allocationSize = 1,initialValue = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "address_sequence")
    private Long addressId;
	private String landmark;
	private String zipcode;
	private String district;
	private String state;
	private String country;
	


}
