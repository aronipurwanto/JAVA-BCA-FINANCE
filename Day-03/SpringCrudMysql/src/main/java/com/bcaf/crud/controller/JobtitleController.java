package com.bcaf.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.crud.model.JobTitleModel;
import com.bcaf.crud.repository.JobtitleRepo;

@Controller
@RequestMapping(value="/job-title/")
public class JobtitleController {
	//@Autowired
	private JobtitleRepo repo;
	
	public JobtitleController(JobtitleRepo jobRepo) {
		repo = jobRepo;
	}
	
	@GetMapping(value="index")
	public ModelAndView index() {
		// membuat object model and view
		ModelAndView view = new ModelAndView("jobtitle/index");
		
		List<JobTitleModel> list = this.repo.findAll();
		view.addObject("list", list);
		return view;
	}
}
