package com.opine.livros.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Servlet;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.opine.livros.domain.Livros;
import com.opine.livros.repositories.LivroRepository;
import com.opine.livros.services.LivroService;
import com.opine.livros.services.exceptions.LivroNaoEncontradoException;

import ch.qos.logback.core.net.server.Client;

@RestController
@RequestMapping("/livros")
public class LivrosResource {

	@Autowired
	LivroService livroService;
	
	@GetMapping                  //Buscar Todos
	public ResponseEntity<List<Livros>> listar() {
		return ResponseEntity.ok().body(livroService.listar());
	}
	
	@PostMapping                   //Salvar
	public ResponseEntity<Livros> salvar(@RequestBody Livros livros) {
		 Livros obj = livroService.salvarLivro(livros);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
		
		 
	}

	@GetMapping(value= "/{id}")    //Buscar por ID
	public ResponseEntity<Livros> buscarPorId(@PathVariable Long id ) {
		Livros livro = null; 
		try {
			livro = livroService.buscarPorId(id);
		} catch (LivroNaoEncontradoException e) {
			 return ResponseEntity.notFound().build();
		}
	    return  ResponseEntity.ok().body(livro);
	}
	
	
	@DeleteMapping(value = "{id}")  //Deletar por ID
	public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
		
		try {
			livroService.deletar(id);
			
		} catch (LivroNaoEncontradoException e) {
		 return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")       //Atualizar
	public ResponseEntity<Livros> atualizarLivro(@RequestBody Livros livros, @PathVariable Long id) {
		livros.setId(id);
		
		try {
			livroService.atualizar(livros);	
		} catch (LivroNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	
}
