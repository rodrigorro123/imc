package br.com.confidencecambio.javabasico.infra.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enum de error
 * @author rodrigo
 *
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {

    UNKNOWN_ERROR("unknown_error"),
    GENERAL_ERROR("general_error"),
    INTEGRATION_ERROR("integration_error"),
    VALIDATION_ERROR("validation_error"),
	NOTFOUND_ERROR("notfound_error");

    @Getter
    private String message;
}

