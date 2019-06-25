package com.bcaf.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	@GetMapping(value="/employee")
	public String index() {
		return "employee/index";
	}
	
	@GetMapping(value="/employee/create")
	public String create() {
		return "employee/create";
	}
	
	@PostMapping(value="/employee/save")
	public String save() {
		return "employee/save";
	}
}
