package br.com.confidencecambio.javabasico.service;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.model.Cliente;
import lombok.extern.slf4j.Slf4j;
/**
 * teste de validacao para o nome conforme pre-requisitos informados.
 * @author rodrigo
 *
 */
@Slf4j
public class ClienteServiceTest {
	
	@Test
	public void validarNomesClienteNull() {
		
		try {
			 new Cliente.Builder(null).build();
		} catch (ApiException e) {
			log.info(e.getMessage());
			assertEquals(e.getMessage(),"Nome nao pode ser nulo ou vazio");
		}
	}
 
	@Test
	public void validarEspacoExtra() {
		try {
			 new Cliente.Builder(" Rodrigo").build();
		} catch (Exception e) {
			log.info(e.getMessage());
			assertEquals(e.getMessage(),"Nome não pode conter espaços extras no início e no fim");
		}
	}
	
	@Test
	public void validarEstruturaNome() {
		try {
			Cliente cliente =  new Cliente.Builder("rodrigo rodrigues de oliveira").build();
			assertEquals(cliente.getNomeMaiscula(),"RODRIGO RODRIGUES DE OLIVEIRA");
			assertEquals(cliente.getNome(),"rodrigo rodrigues de oliveira");
			assertEquals(cliente.getNomeAbreviado(),"Rodrigo R. De Oliveira");
			assertEquals(cliente.getPrimeiroNome(),"Rodrigo");
			assertEquals(cliente.getSobreNome(),"rodrigues de oliveira");
			
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}