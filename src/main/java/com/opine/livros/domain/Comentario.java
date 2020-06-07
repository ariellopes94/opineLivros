package com.opine.livros.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O comentario texto não pode ser vazio")
	@Size(max = 1500 , message = "O comentário não pode conter mais de 1500 caracteres")
	@JsonProperty("comentario") //alterar o nome do atribudo de para retornar para o cliente | "texto" para "comentario"
	private String texto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String usuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="LIVRO_ID")
	@JsonIgnore
	private Livros livro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Livros getLivro() {
		return livro;
	}
	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	
}
