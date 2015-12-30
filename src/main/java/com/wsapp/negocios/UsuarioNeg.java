package com.wsapp.negocios;

import java.util.ArrayList;
import java.util.List;

import com.wsapp.entidades.BaseDados;
import com.wsapp.entidades.Usuario;
import com.wsapp.util.UtilBaseDados;

public class UsuarioNeg {
	public List<Usuario> listarUsuarios() {
		try {
			BaseDados base = UtilBaseDados.recuperaBaseDados();
			return base.getListaUsuarios();
		} catch (Exception e) {
			return new ArrayList<Usuario>();
		}
	}
}
