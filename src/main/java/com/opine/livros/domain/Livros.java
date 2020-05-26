package com.opine.livros.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;



public class Livros {


	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private Long id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private String nome;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private Date publicacao;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private String editora;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private String resumo;
	
	//OneToMany
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private List<Comentario> comentarios;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private String autor;
	
	public Livros() {
		
	}
	
	public Livros (String nome) {
		this.nome = nome;
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
	public Date getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	
}
