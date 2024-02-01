package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.springmvc.domain.Lab;
import com.springmvc.service.LabService;

@Controller
@RequestMapping("/labs")
public class LabController {
	@Autowired
	private LabService labService;
	
	
	@GetMapping
	public String requestLabMethod(Model  model) {
		List<Lab> list = labService.getAllLabList();
		model.addAttribute("LabList", list);
		
		return "labs";
	}
	
	@GetMapping("/lab")
	public String requestLabByName(@RequestParam("name") String name, Model model) {
		Lab labByName = labService.getLabByName(name);
		model.addAttribute("Lab", labByName);
		
		return "lab";
	}
	@PostMapping("/lab")
	public String submitModifyNewLab(@ModelAttribute("modifyLab")Lab lab) {
		labService.setNewLab(lab);
		return "redirect:/labs";
	}
	@ModelAttribute("name")
	public void modifyAttributes(Model model) {
		model.addAttribute("modifyTitle", "수정 프로젝트 내용");
	}
	
	@GetMapping("/add")
	public String requestAddLabForm(@ModelAttribute("NewLab")Lab lab) {
		return "addLab";
	}
	
	@PostMapping("/add")
	public String submitAddNewLab(@ModelAttribute("NewLab")Lab lab) {
		labService.setNewLab(lab);
		return "redirect:/labs";
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 프로젝트 내용");
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("name", "content"); 
    }

}
