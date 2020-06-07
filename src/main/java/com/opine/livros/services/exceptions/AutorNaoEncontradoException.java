package com.opine.livros.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = -7222454384485256214L;
	
	public AutorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AutorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
