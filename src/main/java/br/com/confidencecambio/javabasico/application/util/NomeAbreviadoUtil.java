package br.com.confidencecambio.javabasico.application.util;

import org.springframework.util.StringUtils;
/**
 * realizar abreviacao do nome
 * @author rodrigo
 *
 */
public class NomeAbreviadoUtil {

	public static String getNomeAbreviado(String [] nome) {

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < nome.length; i++) {
			
			if(i == 0 || i == nome.length -1 || nome[i].length() < 3 ){
				result.append( StringUtils.capitalize(nome[i]) ).append( " ");
			}else {
				String inicial = Character.toString( nome[i].charAt(0)).toUpperCase();
				result.append( inicial  ).append( ". "); 
			}
		}
		return result.toString().trim();
	}

}
