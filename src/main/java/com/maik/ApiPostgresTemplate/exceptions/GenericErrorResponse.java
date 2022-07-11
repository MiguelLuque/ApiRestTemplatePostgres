package com.maik.ApiPostgresTemplate.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericErrorResponse {

	// Mensaje de error generico con la naturaleza del error
	private String message;

	// Error específico devuelto
	private String details;
}
