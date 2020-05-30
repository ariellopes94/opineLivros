package com.opine.livros.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Servlet;
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

@RestController
@RequestMapping("/livros")
public class LivrosResource {

	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping                  //Buscar Todos
	public List<Livros> listar() {
		return livroRepository.findAll();
	}
	
	@PostMapping                   //Salvar
	public ResponseEntity<Livros> salvar(@RequestBody Livros livros) {
		 Livros obj = livroRepository.save(livros);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
		
		 
	}

	@GetMapping(value= "/{id}")    //Buscar por ID
	public ResponseEntity<Livros> buscarPorId(@PathVariable Long id ) {
		Optional<Livros> livros = livroRepository.findById(id);
		     Livros obj=  livros.orElse(null);
		     if(obj == null) {
		     return ResponseEntity.notFound().build();
			}
		   return  ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "{id}")  //Deletar por ID
	public void deletarLivro(@PathVariable Long id) {
		
		livroRepository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")       //Atualizar
	public Livros atualizarLivro(@RequestBody Livros livros, @PathVariable Long id) {
		livros.setId(id);
		return livroRepository.save(livros);
	}
	
	
}
