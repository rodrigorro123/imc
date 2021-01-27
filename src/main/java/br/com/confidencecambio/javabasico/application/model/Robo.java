package br.com.confidencecambio.javabasico.application.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import br.com.confidencecambio.javabasico.application.exception.ApiException;
import br.com.confidencecambio.javabasico.application.util.NomeAbreviadoUtil;
import lombok.Data;

@Data
@Valid
public final class Robo {

	@NotEmpty
    private final String nome;
	private final String primeiroNome;
	private final String sobreNome;
	private final String nomeMaiscula;
	private final String nomeAbreviado;

    public static class Builder {
        private final String nome;

        public Builder(String nome) {
            this.nome = nome;
        }

        public Robo build()  throws ApiException {
            return new Robo(this);
        }
    }

    private Robo(Builder builder)  throws ApiException{
    	
		if(!StringUtils.hasText(builder.nome) ) {
            throw ApiException
            .builder()
            .statusCode(HttpStatus.PRECONDITION_FAILED.value())
            .code(ApiException.VALIDATION_ERROR)
            .message("Nome nao pode ser nulo ou vazio")
            .reason("Falha ao validar nome com valor nulo ou vazio")
            .build();
		}
		
		String[] nomSeparado = builder.nome.split(" ", builder.nome.length());
		if(!StringUtils.hasText( nomSeparado[0]) || 
		   !StringUtils.hasText(nomSeparado[nomSeparado.length -1]) ){
            throw ApiException
            .builder()
            .statusCode(HttpStatus.PRECONDITION_FAILED.value())
            .code(ApiException.VALIDATION_ERROR)
            .message("Nome não pode conter espaços extras no início e no fim")
            .reason("Falha ao validar nome com espaco extra")
            .build();
		}
        nome         = builder.nome;
        primeiroNome = nomSeparado[0];
        sobreNome = nome.substring(nomSeparado[0].length()).trim().replace("  ", " ");
        nomeMaiscula = nome.toUpperCase().trim().replace("  ", " ");
        nomeAbreviado = NomeAbreviadoUtil.getNomeAbreviado(nomSeparado);
    }
 
}
