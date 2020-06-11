package com.opine.livros.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.opine.livros.domain.Comentario;
import com.opine.livros.domain.Livros;
import com.opine.livros.services.LivroService;


@RestController
@RequestMapping("/livros")
public class LivrosResource {

	@Autowired
	LivroService livroService;
	
	@GetMapping                  //Buscar Todos
	public ResponseEntity<List<Livros>> listar() {
		return ResponseEntity.ok().body(livroService.listar());
	}
	
	@PostMapping                   //Salvar
	public ResponseEntity<Livros> salvar(@Validated @RequestBody Livros livros) {
		 Livros obj = livroService.salvarLivro(livros);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
		
		 
	}

	@GetMapping(value= "/{id}")    //Buscar por ID
	public ResponseEntity<Livros> buscarPorId(@PathVariable Long id ) {
		
		//Salvar a get na memoria Cache do cliente 
		//CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		//CacheControl cacheControl = CacheControl.maxAge(35, TimeUnit.SECONDS);
		Livros livro = livroService.buscarPorId(id); 
	    return  ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS))
	    		.body(livro);
	    
	    
	}
	
	
	@DeleteMapping(value = "{id}")  //Deletar por ID
	public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
		livroService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")       //Atualizar
	public ResponseEntity<Livros> atualizarLivro(@RequestBody Livros livros, @PathVariable Long id) {
		livros.setId(id);
		livroService.atualizar(livros);	
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@RequestMapping(value = "{id}/comentarios")
	public ResponseEntity<Void> adicionarCometario(@PathVariable("id") Long livroId , 
			                       @RequestBody Comentario comentario) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		comentario.setUsuario(auth.getName());
		
		livroService.salvarComentario(livroId, comentario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "{id}/comentarios")
	public ResponseEntity<List<Comentario>> buscarComentarios(@PathVariable("id") Long livroId){
		 List<Comentario> livroComentarios = livroService.listarComentarios(livroId);
		 
		 return ResponseEntity.ok().body(livroComentarios);
	}
	
}
