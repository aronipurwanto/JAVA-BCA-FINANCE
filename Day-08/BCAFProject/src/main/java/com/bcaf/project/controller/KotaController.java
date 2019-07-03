package com.bcaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bcaf.project.model.Kota;
import com.bcaf.project.model.Provinsi;
import com.bcaf.project.repository.KotaRepo;
import com.bcaf.project.repository.ProvinsiRepo;

@Controller
@RequestMapping(value="/kota/")
public class KotaController {
	@Autowired
	private KotaRepo repo;
	
	@Autowired
	private ProvinsiRepo propRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("kota/index");
		
		List<Kota> list = this.repo.findAll();
		view.addObject("list", list);
		
		return view;
	}
	
	@GetMapping(value="create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("kota/_form");
		view.addObject("kota", new Kota());
		
		List<Provinsi> listProp = this.propRepo.findAll();
		view.addObject("listProp", listProp);
		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Kota Kota, BindingResult result) {
		ModelAndView view = new ModelAndView("kota/_form");
		// jika ada error
		if(result.hasErrors()) {
			view.addObject("kota", Kota);
		}else {
			this.repo.save(Kota);
			view.addObject("kota", new Kota());
		}
		return view;
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kota/_form");
		Kota  item = this.repo.findById(id).orElse(null);
		view.addObject("kota", item);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("kota/_list");
		
		List<Kota> list = this.repo.findAll();
		view.addObject("list", list);
		
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("kota/_hapus");
		Kota  item = this.repo.findById(id).orElse(null);
		view.addObject("kota", item);
		return view;
	}
}
