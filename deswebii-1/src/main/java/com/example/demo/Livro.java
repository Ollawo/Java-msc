package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String autor;
	String titulo;
	Integer ano;
	public Livro(Long id, String autor, String titulo, Integer ano) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.ano = ano;
	}
	public Livro() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
