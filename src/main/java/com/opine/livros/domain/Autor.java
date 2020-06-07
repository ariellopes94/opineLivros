package com.opine.livros.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nome;
	
	@JsonFormat(pattern =  "dd/MM/yyyy")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livros> livros = new ArrayList<>();
	
	public Autor() {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}
	
	
}
