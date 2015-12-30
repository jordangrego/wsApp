package com.wsapp.exceptions;

@SuppressWarnings("serial")
public class WsAppException extends Exception {
	public WsAppException(String mensagem){
		super(mensagem);
	}
}
