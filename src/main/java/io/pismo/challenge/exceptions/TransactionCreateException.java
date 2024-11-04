package io.pismo.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TransactionCreateException extends RuntimeException {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = -6854016372384601943L;

	public TransactionCreateException(String message) {
		super(message);
	}
	
}

