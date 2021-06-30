package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bibliotecas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	String endereco;
	Integer qtdLivros;
	Integer qtdCarros;
	Integer qtdPessoas;
	public Bibliotecas(Long id, String nome, String endereco, Integer qtdLivros, Integer qtdCarros,
			Integer qtdPessoas) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.qtdLivros = qtdLivros;
		this.qtdCarros = qtdCarros;
		this.qtdPessoas = qtdPessoas;
	}
	public Bibliotecas() {
	}
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getQtdLivros() {
		return qtdLivros;
	}
	public void setQtdLivros(Integer qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
	public Integer getQtdCarros() {
		return qtdCarros;
	}
	public void setQtdCarros(Integer qtdCarros) {
		this.qtdCarros = qtdCarros;
	}
	public Integer getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	
}
