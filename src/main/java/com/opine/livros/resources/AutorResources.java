package com.opine.livros.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opine.livros.domain.Autor;
import com.opine.livros.services.AutorService;

@RestController
@RequestMapping("autores")
public class AutorResources {

	@Autowired
	private AutorService autorService;
	
	@GetMapping
	public ResponseEntity<List<Autor>> listar(){
		List<Autor> autores = autorService.buscarTodosAutores();
		
		return ResponseEntity.ok().body(autores);
	}
}
