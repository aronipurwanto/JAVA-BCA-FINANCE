package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.ProvinsiRepo;

@Controller
@RequestMapping(value="/provinsi/")
public class ProvinsiController {
	@Autowired
	private ProvinsiRepo repo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("provinsi/index");
		
		List<Provinsi> list = this.repo.findAll();
		view.addObject("list", list);
		
		return view;
	}
	
	@GetMapping(value="create")
	public ModelAndView admin() {
		return new ModelAndView("provinsi/_form");
	}
	
	@GetMapping(value="update")
	public ModelAndView manager() {
		return new ModelAndView("provinsi/_form");
	}
}
