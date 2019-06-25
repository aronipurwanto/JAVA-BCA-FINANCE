package com.bcaf.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(value="/")
	public String index() {
		return "home/index";
	}
	
	@GetMapping(value="/home/contact-us")
	public String contact() {
		return "home/contact";
	}
	
	@GetMapping(value="/contact-us")
	public String contactUs() {
		return "home/contact";
	}
	
	@GetMapping(value="/home/about-us")
	public String about() {
		return "home/about";
	}
	
	@GetMapping(value="/about-us")
	public String aboutUs() {
		return "home/about";
	}
}
