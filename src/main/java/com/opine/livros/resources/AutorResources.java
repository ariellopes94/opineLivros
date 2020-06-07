package com.opine.livros.resources;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.opine.livros.domain.Autor;
import com.opine.livros.services.AutorService;

@RestController
@RequestMapping("autores")
public class AutorResources {

	@Autowired
	private AutorService autorService;
	
	 
	   /*
	    * Negociação de conteúdos com Media Type.
	    * 
	    * 
	    * @RequestMapping(method = RequestMethod.GET , produces = {             
	    * MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE 
	    *
	    *ADICIONADR DEPEDENCIA NO POM
	    *POM
	    *
	    *<dependency>
	    *    <groupId> com.fasterxml.jackson.dataformat</groupId>
	    *    <artifactId>jackson-dataformat-xml</artifactId>
	    *</dependency>
	    *  </dependencies>
	    *
	    *
	    * Postman -> Headers -> 
        *  content-Type               application/json   | ACEITA JSON
        * Accept                     application/xml   | ACEITA XML
	    */
	
	@RequestMapping(method = RequestMethod.GET , produces = {              //ACEITAR RETORNO PARA JSON E XML 
	   MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE  //Tem que adicionar a Depecencia do XML no POM
	  
	})
	public ResponseEntity<List<Autor>> listar(){
		List<Autor> autores = autorService.buscarTodosAutores();
		
		return ResponseEntity.ok().body(autores);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvarAutor(@Validated @RequestBody Autor autor){
		     autor = autorService.salvarLivro(autor);
		  
		  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		  
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Autor>> buncarPorId(@PathVariable Long id){
		Optional<Autor> autor = autorService.buscarPorId(id);	
		return ResponseEntity.ok().body(autor);
		
	}
	
}
