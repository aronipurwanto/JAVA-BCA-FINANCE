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
@RequestMapping(value="/provinsi/")
public class ProvinsiController {
	@Autowired
	private ProvinsiRepo repo;
	
	@Autowired
	private KotaRepo kotaRepo;
	
	@GetMapping(value="index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("provinsi/index");
		
		List<Provinsi> list = this.repo.findAll();
		view.addObject("list", list);
		
		return view;
	}
	
	@GetMapping(value="create")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView("provinsi/_form");
		view.addObject("provinsi", new Provinsi());
		return view;
	}
	
	@PostMapping(value="save")
	public ModelAndView save(@ModelAttribute Provinsi provinsi, BindingResult result) {
		ModelAndView view = new ModelAndView("provinsi/_form");
		// jika ada error
		if(result.hasErrors()) {
			view.addObject("provinsi", provinsi);
		}else {
			this.repo.save(provinsi);
			view.addObject("provinsi", new Provinsi());
		}
		return view;
	}
	
	@GetMapping(value="edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("provinsi/_form");
		Provinsi  item = this.repo.findById(id).orElse(null);
		view.addObject("provinsi", item);
		return view;
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("provinsi/_list");
		
		List<Provinsi> list = this.repo.findAll();
		view.addObject("list", list);
		
		return view;
	}
	
	@GetMapping(value="hapus/{id}")
	public ModelAndView hapus(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("provinsi/_form");
		Provinsi  item = this.repo.findById(id).orElse(null);
		view.addObject("provinsi", item);
		return view;
	}
	
	@PostMapping(value="remove")
	public ModelAndView remove(@ModelAttribute Provinsi provinsi) {
		//#1 check data di kota
		if(this.kotaRepo.findByProvinsiId(provinsi.getId()).size()==0) {
			// jika tidak ada data provinsi di kota, maka proses hapus dilakukan
			this.repo.delete(provinsi);
		}
		
		ModelAndView view = new ModelAndView("provinsi/_form");
		view.addObject("kota", new Kota());
		return view;
	}
}
