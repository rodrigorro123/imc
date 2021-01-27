package br.com.confidencecambio.javabasico.service;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.model.Gerente;
import lombok.extern.slf4j.Slf4j;
/**
 * teste de validacao para o nome conforme pre-requisitos informados.
 * @author rodrigo
 *
 */
@Slf4j
public class GerenteServiceTest {
	
	@Test
	public void validarNomesGerenteNull() {
		
		try {
			 new Gerente.Builder(null).build();
		} catch (ApiException e) {
			log.info(e.getMessage());
			assertEquals(e.getMessage(),"Nome nao pode ser nulo ou vazio");
		}
	}
 
	@Test
	public void validarEspacoExtra() {
		try {
			 new Gerente.Builder(" Rodrigo ").build();
		} catch (Exception e) {
			log.info(e.getMessage());
			assertEquals(e.getMessage(),"Nome não pode conter espaços extras no início e no fim");
		}
	}
	
	@Test
	public void validarEstruturaNome() {
		try {
			Gerente gerente =  new Gerente.Builder("rodrigo rodrigues de oliveira").build();
			assertEquals(gerente.getNomeMaiscula(),"RODRIGO RODRIGUES DE OLIVEIRA");
			assertEquals(gerente.getNome(),"rodrigo rodrigues de oliveira");
			assertEquals(gerente.getNomeAbreviado(),"Rodrigo R. De Oliveira");
			assertEquals(gerente.getPrimeiroNome(),"Rodrigo");
			assertEquals(gerente.getSobreNome(),"rodrigues de oliveira");
			
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}