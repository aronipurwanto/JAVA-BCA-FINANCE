package com.staxrt.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.staxrt.tutorial.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	// 1. Spring JPA In cause using @Query
	@Query("SELECT a FROM Address a WHERE a.userId=:userId") 
	public Address findUserAddresses(@Param("userId") Long userId);
	
	// 2. bisa langsung seperi ini
	public Address findByUserId(Long userId);
	
}
