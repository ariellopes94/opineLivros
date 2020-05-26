package com.opine.livros.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opine.livros.domain.Livros;

@RestController
@RequestMapping("/livros")
public class LivrosResource {

	@GetMapping
	public List<Livros> listar() {
		
		Livros l1 = new Livros("Aprenda Java");
		Livros l2 = new Livros("Rest aplicado");
		Livros l3 = new Livros("Git passo-a-passo");

		List<Livros> livros = new  ArrayList();
		
		livros.addAll(Arrays.asList(l1,l2,l3));
		return livros;
	}

}
