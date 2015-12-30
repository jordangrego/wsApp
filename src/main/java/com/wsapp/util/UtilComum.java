package com.wsapp.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class UtilComum {
	
	public static int calcularIdade(Date dataNascimento) {
		if (dataNascimento != null) {
			Calendar now = Calendar.getInstance();
			Calendar clone = Calendar.getInstance();
			clone.setTime(dataNascimento); // Otherwise changes are been
											// reflected.
			int years = -1;
			while (!clone.after(now)) {
				clone.add(Calendar.YEAR, 1);
				years++;
			}

			return years;
		} else {
			return 0;
		}
	}

	public static void gravarArquivo(byte[] arquivo, String pathArquivo) throws IOException {
		FileOutputStream fos = new FileOutputStream(pathArquivo);
		fos.write(arquivo);
		fos.close();
	}

	public static String recuperarTextoArquivo(String pathArquivo) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pathArquivo));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			return sb.toString();
		} finally {
			br.close();
		}
	}

	public static String recuperarPropriedadeWsApp(String propriedade)
			throws IOException {
		Properties prop = new Properties();
		String propFileName = "wsApp.properties";

		InputStream input = UtilComum.class.getClassLoader().getResourceAsStream(propFileName);

		// load a properties file
		prop.load(input);

		return prop.getProperty(propriedade);
	}
}
