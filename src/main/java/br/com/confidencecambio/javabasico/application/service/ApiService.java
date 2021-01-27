package br.com.confidencecambio.javabasico.application.service;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.model.response.ResultImcResponse;

public interface ApiService {

	ResultImcResponse getImc( Double peso, Double altura) throws ApiException;
	
}
