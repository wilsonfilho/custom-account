package io.pismo.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TransactionAmountInvalidException extends RuntimeException {

	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 4613517064947702286L;
	
	public TransactionAmountInvalidException(String message) {
		super(message);
	}
	
}
