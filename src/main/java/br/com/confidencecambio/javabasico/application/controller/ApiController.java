package br.com.confidencecambio.javabasico.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.model.error.Error;
import br.com.confidencecambio.javabasico.application.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/teste")
@RequiredArgsConstructor
public class ApiController {

	 private final ApiService apiService;

	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "imc",
    produces = {"application/json"},
    method = RequestMethod.GET)
	public ResponseEntity<?> updateMovimentacao( @RequestParam(required = true, name = "peso")   Double peso,
												 @RequestParam(required = true, name = "altura") Double altura) throws ApiException {

		try {
			return ResponseEntity.ok(apiService.getImc(peso, altura));

		} catch (ApiException ex) {
			log.error(ex.getMessage());
			return ResponseEntity.status(ex.getStatusCode()).body( Error.builder()
																		.code(ex.getStatusCode().toString())
																		.message(ex.getCode())
																		.description(ex.getMessage()).build()
																  );
		}
	}

}
