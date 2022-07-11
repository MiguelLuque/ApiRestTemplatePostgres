package com.maik.ApiPostgresTemplate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

/**
 * The Class ExceptionController.
 */
@ControllerAdvice
public class ExceptionController {
	
	/**
	 * Generic exception.
	 * 
	 * Se lanzará una excepción contralada cuando reciba otra que no haya sido capturada por otro de los métodos
	 *
	 * @param e the e
	 * @return the response entity
	 */
	@ExceptionHandler(value = Throwable.class)
	public ResponseEntity<GenericErrorResponse> genericException(Throwable e) {

		GenericErrorResponse error = new GenericErrorResponse("Internal server error", e.getMessage());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

	/**
	 * Price not found exception. 
	 * 
	 * Lanzará una excepción cuando no logre recuperar un price 
	 *
	 * @param e the e
	 * @return the response entity
	 */
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<GenericErrorResponse> priceNotFoundException(NoSuchElementException e) {

		GenericErrorResponse error = new GenericErrorResponse("Price not found", e.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
	

	/**
	 * Bad request exception.
	 * 
	 * Lanzará una excepción cuando no se informen los parámetros correctamente
	 *
	 * @param e the e
	 * @return the response entity
	 */
	@ExceptionHandler({MissingServletRequestParameterException.class, MethodArgumentTypeMismatchException.class })
	public ResponseEntity<GenericErrorResponse> badRequestException(Exception e) {

		GenericErrorResponse error = new GenericErrorResponse("Bad request", e.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
