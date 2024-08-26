package com.github.gadini.complainceSoftware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.gadini.complainceSoftware.repository.ComplianceRepository;

@Controller
public class IndexController {
	
	@Autowired
    private ComplianceRepository complianceRepository;
	
	@GetMapping
	public String index(Model model) {
        model.addAttribute("compliances", complianceRepository.findAll());
        return "index";
    }
	
	//@GetMapping
	//public String index() {
	//	return "index";
	//}
	
}
