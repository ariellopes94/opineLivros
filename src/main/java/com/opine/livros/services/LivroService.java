package com.opine.livros.services;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.opine.livros.domain.Comentario;
import com.opine.livros.domain.Livros;
import com.opine.livros.repositories.ComentariosRepository;
import com.opine.livros.repositories.LivroRepository;
import com.opine.livros.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livros> listar(){
		return livroRepository.findAll();
	}
	
	public Livros buscarPorId(Long id) {
	   Optional<Livros> obj = livroRepository.findById(id);
	   Livros livro=  obj.orElse(null);
	   
	   if(livro == null) {
		   throw new LivroNaoEncontradoException("O Livro não pôde ser encontrado.");
	   }
		 return livro;
	}
	
	public Livros salvarLivro(Livros livro) {
		livro.setId(null);
		return  livroRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livroRepository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O livro não pode ser encontrado");
		}
	
	}
	
	public void atualizar(Livros livro) {
		verificarExistencia(livro);
		livroRepository.save(livro);
	}
	
	private void verificarExistencia(Livros livro) {
		buscarPorId(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroid , Comentario comentario) {
		Livros livros = buscarPorId(livroid);
		
		comentario.setLivro(livros);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId){
	       Livros livro =	buscarPorId(livroId);
		return livro.getComentarios();
	}
}
