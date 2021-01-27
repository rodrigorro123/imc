package br.com.confidencecambio.javabasico.application.model.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String code;
    private String message;
    private String description;
}