package com.tutorial.mapping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.mapping.model.Laptop;
import com.tutorial.mapping.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

	
	@Autowired
	private LaptopService laptopService;
	
	
	
	@PostMapping("/add")
	
	public ResponseEntity<String>addLaptop(@RequestBody Laptop laptop){
		
		
		return laptopService.addLaptop(laptop);
	}
	
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<String>deleteLaptopWithId(@PathVariable Long id){
		
		
		return laptopService.deleteLaptopWithId(id);
	}
}
