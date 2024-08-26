package com.github.gadini.complainceSoftware.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "compliance")
public class Compliance extends AbstractEntity<Long>{

	@Column(nullable = false, length = 255)
	private String titulo;
	
	@Column(nullable = false, length = 100)
	private String tipo;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Column(nullable = false, length = 500)
	private String corpo;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dataAlteracao;

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
	
}
