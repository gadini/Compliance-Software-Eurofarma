package com.github.gadini.complainceSoftware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gadini.complainceSoftware.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByNomeUsuario(String nomeUsuario);
	
}
