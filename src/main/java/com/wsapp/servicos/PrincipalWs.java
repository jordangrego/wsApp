package com.wsapp.servicos;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebService;

import com.wsapp.entidades.Usuario;
import com.wsapp.negocios.UsuarioNeg;
import com.wsapp.servicos.entidades.ListaUsuarios;

@WebService(endpointInterface = "com.wsapp.servicos.IPrincipalWs")
public class PrincipalWs implements IPrincipalWs {

	@Override
	public String printMessage() {
		return "Rodou: " + (new Date()).toString();
	}

	@Override
	public ListaUsuarios listarUsuarios() {
		System.out.println("Requisicao realizada no servico listarUsuarios() <----------------------------------");
		UsuarioNeg neg = new UsuarioNeg();
		ArrayList<Usuario> lista = (ArrayList)neg.listarUsuarios();
		
		ListaUsuarios listaUsuario = new ListaUsuarios();
		listaUsuario.setUsuario(lista);
		
		return listaUsuario;
	}

}
