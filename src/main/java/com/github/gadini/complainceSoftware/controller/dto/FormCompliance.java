package com.github.gadini.complainceSoftware.controller.dto;

import java.time.LocalDate;

import com.github.gadini.complainceSoftware.model.Compliance;

public class FormCompliance {

	private Long id;
	private String titulo;
	private String tipo;
	private LocalDate dataEntrada = LocalDate.now();
	private String corpo;
	private LocalDate dataAlteracao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	public FormCompliance toForm(Compliance compliance) {
		this.id = compliance.getId();
		this.titulo = compliance.getTitulo();
		this.tipo = compliance.getTipo();
		this.dataEntrada = compliance.getDataEntrada();
		this.corpo = compliance.getCorpo();
		this.dataAlteracao = compliance.getDataAlteracao();
		return this;
	}
	
	public Compliance toModel() {
		Compliance compliance = new Compliance();
		compliance.setId(this.getId());
		compliance.setTitulo(this.getTitulo());
		compliance.setTipo(this.getTipo());
		compliance.setDataEntrada(this.getDataEntrada());
		compliance.setCorpo(this.getCorpo());
		compliance.setDataAlteracao(this.getDataAlteracao());
		return compliance;
	}
	
}
