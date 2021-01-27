package br.com.confidencecambio.javabasico.application.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.model.response.ResultImcResponse;
import br.com.confidencecambio.javabasico.application.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementacao para calculos principais
 * @author rodrigo
 *
 */
@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {

	/**
	 * calculo do imc, utilizando funcao de potencia;
	 */
	@Override
	public ResultImcResponse getImc(Double peso, Double altura) throws ApiException {
		try {

			ResultImcResponse imcResponse = new ResultImcResponse();
			
			Double result = peso / Math.pow(altura, 2);
			BigDecimal bd = new BigDecimal(result).setScale(3, RoundingMode.HALF_EVEN);
			
			imcResponse.setResultado(bd.doubleValue());
			
			return imcResponse ;
			
		} catch (Exception e) {
			log.error(e.getMessage());
            throw ApiException
            .builder()
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .code(ApiException.GENERAL_ERROR)
            .message("Erro ao calcular IMC")
            .reason("Falha no calculo IMC")
            .build();
		}
		
	}


}
