package com.staxrt.tutorial.controller;

import java.util.Collection;
import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.staxrt.tutorial.model.Address;
import com.staxrt.tutorial.repository.AddressRepository;


@RestController
@RequestMapping("/api/v1")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/addresses")
	@ResponseBody
	public List<Address> getAllAddress() {
	  return addressRepository.findAll();
	}

	@GetMapping("/addresses/{id}")
	@ResponseBody
	public Address getUserAddress(Long uid) {
		return addressRepository.findUserAddresses(uid);	
	}
	
	public AddressController() {
		
	}
}
