package com.opine.livros.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
