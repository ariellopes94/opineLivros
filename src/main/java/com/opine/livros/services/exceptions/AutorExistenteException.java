package com.opine.livros.services.exceptions;

public class AutorExistenteException extends RuntimeException{
	private static final long serialVersionUID = -7222454384485256214L;
	
	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
