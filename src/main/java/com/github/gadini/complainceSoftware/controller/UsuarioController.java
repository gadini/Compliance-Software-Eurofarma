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

import com.github.gadini.complainceSoftware.controller.dto.FormUsuario;
import com.github.gadini.complainceSoftware.model.Compliance;
import com.github.gadini.complainceSoftware.model.Usuario;
import com.github.gadini.complainceSoftware.repository.UsuarioRepository;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping()
	public String create(Model model) {
		model.addAttribute("usuario", new FormUsuario());
		return "usuario/form";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<Usuario> usuarios = usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("usuarios", usuarios);
		return "usuario/list";
	}
	
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("usuario", new FormUsuario());
		return "usuario/login";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute FormUsuario usuario) {		
		Usuario entity = usuario.toModel();
		
		usuarioRepository.save(entity);
		return "redirect:/usuarios";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Usuario entity = usuarioRepository.findById(id).orElse(new Usuario());
		
		FormUsuario usuario = new FormUsuario().toForm(entity);
		
		model.addAttribute("usuario", usuario);
		return "usuario/form";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		return "redirect:/usuarios";
	}
	
}
