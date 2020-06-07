package com.opine.livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opine.livros.domain.Autor;
import com.opine.livros.repositories.AutorRepository;
import com.opine.livros.services.exceptions.AutorExistenteException;
import com.opine.livros.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> buscarTodosAutores(){
		return autorRepository.findAll();
	}
	
	public Autor salvarLivro(Autor autor) {
		
		if(autor.getId() != null) {
			  Optional<Autor> autores = autorRepository.findById(autor.getId());	
			 if(autores.isPresent()) {
				throw new AutorExistenteException("O Autor já Existe");
			}
		}
		return autorRepository.save(autor);
	}
	
	public Optional<Autor> buscarPorId(Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		
		if(!autor.isPresent()) {
		throw new AutorNaoEncontradoException("O autor não pode ser encontado.");
	}
	return autor;

}
}
