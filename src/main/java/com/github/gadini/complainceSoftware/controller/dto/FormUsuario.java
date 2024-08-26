package com.github.gadini.complainceSoftware.controller.dto;

import com.github.gadini.complainceSoftware.model.Usuario;

public class FormUsuario {

	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String nomeUsuario;
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	public FormUsuario toForm(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.senha = usuario.getSenha();
		return this;
	}
	
	public Usuario toModel() {
		Usuario usuario = new Usuario();
		usuario.setId(this.getId());
		usuario.setNome(this.getNome());
		usuario.setSobrenome(this.getSobrenome());
		usuario.setCpf(this.getCpf());
		usuario.setEmail(this.getEmail());
		usuario.setNomeUsuario(this.getNomeUsuario());
		usuario.setSenha(this.getSenha());
		return usuario;
	}
	
}
