package com.wsapp.servicos;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.wsapp.servicos.entidades.ListaUsuarios;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IPrincipalWs {
	
	@WebMethod
	String printMessage();

	@WebMethod
	ListaUsuarios listarUsuarios();
}
