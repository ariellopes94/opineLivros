package com.opine.livros.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.opine.livros.domain.DetalhesErro;
import com.opine.livros.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceotionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handeLivroNaoEncontradoException(LivroNaoEncontradoException e,
			                                                    HttpServletRequest request ){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O Livro não pôde  ser encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialbook.com/404");
		erro.setTimes(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
