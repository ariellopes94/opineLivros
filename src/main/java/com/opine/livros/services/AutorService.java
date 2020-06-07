package com.opine.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.opine.livros.domain.Autor;
import com.opine.livros.repositories.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> buscarTodosAutores(){
		return autorRepository.findAll();
		
	}

}
