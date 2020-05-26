package com.opine.livros.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivrosResource {

	@GetMapping
	public String listar() {
		return "Hello word";
	}

}
