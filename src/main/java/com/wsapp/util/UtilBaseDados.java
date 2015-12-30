package com.wsapp.util;

import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.wsapp.entidades.BaseDados;

public class UtilBaseDados {
	
	public static BaseDados recuperaBaseDados() throws IOException {
		String pathBaseDados = UtilComum.recuperarPropriedadeWsApp("pathBaseDados");
		String xmlArquivo = UtilComum.recuperarTextoArquivo(pathBaseDados);
		XStream xstream = new XStream();
		BaseDados baseDados = (BaseDados)xstream.fromXML(xmlArquivo); 
		return baseDados;
	}
	
	public static void gravaBaseDados(BaseDados baseDados) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("br.com.estudo.entidade.BaseDados", BaseDados.class); 
		String xml = xstream.toXML(baseDados); 
		String pathBaseDados = UtilComum.recuperarPropriedadeWsApp("pathBaseDados");
		UtilComum.gravarArquivo(xml.getBytes(), pathBaseDados);
	}
}
