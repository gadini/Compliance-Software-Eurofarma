package com.github.gadini.complainceSoftware.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario extends AbstractEntity<Long>{

	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false, length = 100)
	private String sobrenome;
	
	@Column(nullable = false, length = 25)
	private String cpf;
	
	@Column(nullable = false, length = 255)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String nomeUsuario;
	
	@Column(nullable = false, length = 100)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
