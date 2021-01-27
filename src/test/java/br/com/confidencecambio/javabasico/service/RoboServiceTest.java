package br.com.confidencecambio.javabasico.service;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.model.Robo;
import lombok.extern.slf4j.Slf4j;
/**
 * teste de validacao para o nome conforme pre-requisitos informados.
 * @author rodrigo
 *
 */
@Slf4j
public class RoboServiceTest {
	
	@Test
	public void validarNomesRoboNull() {
		
		try {
			 new Robo.Builder(null).build();
		} catch (ApiException e) {
			log.info(e.getMessage());
			assertEquals(e.getMessage(),"Nome nao pode ser nulo ou vazio");
		}
	}
 
	@Test
	public void validarEspacoExtra() {
		try {
			 new Robo.Builder(" Rodrigo").build();
		} catch (Exception e) {
			log.info(e.getMessage());
			assertEquals(e.getMessage(),"Nome não pode conter espaços extras no início e no fim");
		}
	}
	
	@Test
	public void validarEstruturaNome() {
		try {
			Robo robo =  new Robo.Builder("rodrigo rodrigues de oliveira").build();
			assertEquals(robo.getNomeMaiscula(),"RODRIGO RODRIGUES DE OLIVEIRA");
			assertEquals(robo.getNome(),"rodrigo rodrigues de oliveira");
			assertEquals(robo.getNomeAbreviado(),"Rodrigo R. De Oliveira");
			assertEquals(robo.getPrimeiroNome(),"Rodrigo");
			assertEquals(robo.getSobreNome(),"rodrigues de oliveira");
			
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}