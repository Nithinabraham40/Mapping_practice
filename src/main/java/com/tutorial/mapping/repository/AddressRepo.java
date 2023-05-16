package com.tutorial.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tutorial.mapping.model.Address;

import jakarta.transaction.Transactional;

public interface AddressRepo extends JpaRepository<Address, Long>{

	
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_address set landmark=:landmark where address_id=:addressId",
			nativeQuery = true
			)
	
	public void updatelandmark(Long addressId,String landmark);

}
