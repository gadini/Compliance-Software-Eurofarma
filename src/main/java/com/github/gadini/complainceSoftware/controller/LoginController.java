package com.github.gadini.complainceSoftware.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.gadini.complainceSoftware.controller.dto.FormCompliance;
import com.github.gadini.complainceSoftware.controller.dto.FormUsuario;
import com.github.gadini.complainceSoftware.model.Compliance;
import com.github.gadini.complainceSoftware.model.Usuario;
import com.github.gadini.complainceSoftware.repository.UsuarioRepository;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@GetMapping()
	public String login() {
		return "login/login";
	}
	
	@PostMapping("log")
	public String log(String nomeUsuario, String senha) {		
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByNomeUsuario(nomeUsuario);
	    
	    if (usuarioExistente.isPresent() && usuarioExistente.get().getSenha().equals(senha)) {
	    	return "redirect:/";
	    }
	    else {
	    	return "redirect:/login";
	    }
	}
	
}
