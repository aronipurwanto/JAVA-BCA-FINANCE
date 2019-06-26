package com.bcaf.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value = "create")
	public ModelAndView create() {
		ModelAndView view  = new ModelAndView("jobtitle/create");
		view.addObject("item", new JobTitleModel());
		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute JobTitleModel jobtitle) {
		ModelAndView view = new ModelAndView("jobtitle/save");
		// perintah simpan ke database
		this.repo.save(jobtitle);
		// mengirim object item ke view, data item dari jobtitle
		view.addObject("item", jobtitle);
		return view;
	}
	
	@GetMapping(value = "edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		// mempersiapan view yang akan digunakan di request ini
		ModelAndView view  = new ModelAndView("jobtitle/edit");
		// ambil data jobtitle berdasarkan id, kemudian disimpan ke object item
		JobTitleModel item = this.repo.findById(id).orElse(null);
		// object item dikirim ke view melalui object view
		view.addObject("item", item);
		return view;
	}
	
	@PostMapping(value="update")
	public ModelAndView update(@ModelAttribute JobTitleModel jobtitle) {
		ModelAndView view = new ModelAndView("jobtitle/update");
		// perintah simpan ke database
		this.repo.save(jobtitle);
		// mengirim object item ke view, data item dari jobtitle
		view.addObject("item", jobtitle);
		return view;
	}
	
	@GetMapping(value = "hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Integer id) {
		// mempersiapan view yang akan digunakan di request ini
		ModelAndView view  = new ModelAndView("jobtitle/hapus");
		// ambil data jobtitle berdasarkan id, kemudian disimpan ke object item
		JobTitleModel item = this.repo.findById(id).orElse(null);
		// object item dikirim ke view melalui object view
		view.addObject("item", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute JobTitleModel jobtitle) {
		// perintah simpan ke database
		this.repo.delete(jobtitle);
		// mengirim object item ke view, data item dari jobtitle
		ModelAndView view = new ModelAndView("redirect:/job-title/index");
		return view;
	}
}
