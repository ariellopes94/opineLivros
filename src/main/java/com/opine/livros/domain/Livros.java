package com.opine.livros.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
public class Livros {


	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	//@Transient //Hibernate desconsiderar
	
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	@ManyToOne
	@JsonInclude(JsonInclude.Include.NON_NULL) // Quando a a variavel for Null ela nao retorna pra tela
	private Autor autor;
	
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
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
}
