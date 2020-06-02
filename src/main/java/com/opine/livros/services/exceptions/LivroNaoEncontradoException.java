package com.opine.livros.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = -7222454384485256214L;
	
	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
