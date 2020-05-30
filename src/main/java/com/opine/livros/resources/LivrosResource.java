package com.opine.livros.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opine.livros.domain.Livros;
import com.opine.livros.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResource {

	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping
	public List<Livros> listar() {
		return livroRepository.findAll();
	}
	
	@PostMapping
	public Livros salvar(@RequestBody Livros livros) {
		return livroRepository.save(livros);
	}

	@GetMapping(value= "/{id}")
	public Optional<Livros> buscarPorId(@PathVariable Long id ) {
		return livroRepository.findById(id);
	}
	
	@DeleteMapping(value = "{id}")
	public void deletarLivro(@PathVariable Long id) {
		
		livroRepository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Livros atualizarLivro(@RequestBody Livros livros, @PathVariable Long id) {
		livros.setId(id);
		return livroRepository.save(livros);
	}
	
	
}
