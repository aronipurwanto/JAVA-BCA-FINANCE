package com.bcaf.bootcamp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcaf.bootcamp.model.EmployeeModel;

@Controller
public class EmployeeController {

	@GetMapping(value="/employee") // url
	public String index() {
		return "employee/index"; // view
	}
	
	@GetMapping(value="/employee/create") // url
	public String create() {
		return "employee/create"; // view
	}
	
	@PostMapping(value="/employee/save") //url
	public String save(HttpServletRequest request, Model model) {
		// request untuk menerima data dari form employee/create
		String id = request.getParameter("id");
		String nama = request.getParameter("nama");
		String tptLahir = request.getParameter("tptLahir");
		String alamat = request.getParameter("alamat");
		String tglLahir = request.getParameter("tglLahir");
		
		// model untuk mengirim data dari controller ke view
		model.addAttribute("vid", id);
		model.addAttribute("vnama", nama);
		model.addAttribute("vtptLahir", tptLahir);
		model.addAttribute("valamat", alamat);
		model.addAttribute("vtglLahir", tglLahir);
		
		return "employee/save"; // view
	}
	
	@GetMapping(value="/employee/baru") // url
	public String baru() {
		return "employee/add"; // view
	}
	
	@PostMapping(value="/employee/simpan")
	public String simpan(@ModelAttribute EmployeeModel emp, Model model) {
		model.addAttribute("vemp", emp);
		return "employee/simpan";
	}
}
