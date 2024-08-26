package com.github.gadini.complainceSoftware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.gadini.complainceSoftware.controller.dto.FormCompliance;
import com.github.gadini.complainceSoftware.model.Compliance;
import com.github.gadini.complainceSoftware.repository.ComplianceRepository;

@Controller
@RequestMapping("compliances")
public class ComplianceController {
	
	@Autowired
	private ComplianceRepository complianceRepository;
	
	@GetMapping()
	public String create(Model model) {
		model.addAttribute("compliance", new FormCompliance());
		return "compliance/form";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<Compliance> compliances = complianceRepository.findAll(Sort.by(Sort.Direction.ASC, "titulo"));
		model.addAttribute("compliances", compliances);
		return "compliance/list";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute FormCompliance compliance) {		
		Compliance entity = compliance.toModel();
		
		complianceRepository.save(entity);
		return "redirect:/compliances";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Compliance entity = complianceRepository.findById(id).orElse(new Compliance());
		
		FormCompliance compliance = new FormCompliance().toForm(entity);
		
		model.addAttribute("compliance", compliance);
		return "compliance/update";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		complianceRepository.deleteById(id);
		return "redirect:/compliances";
	}

}
