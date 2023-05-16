package com.tutorial.mapping.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDao {
	private String laptopName;
	private String laptopBrand;
	private Integer laptopPrice;
}
