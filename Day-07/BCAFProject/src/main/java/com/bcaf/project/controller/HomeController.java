package com.bcaf.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping(value="/home")
	public ModelAndView index() {
		return new ModelAndView("home/index");
	}
	
	@GetMapping(value="/admin")
	public ModelAndView admin() {
		return new ModelAndView("home/admin");
	}
	
	@GetMapping(value="/manager")
	public ModelAndView manager() {
		return new ModelAndView("home/manager");
	}
}
