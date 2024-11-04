package io.pismo.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperationTypeNotFoundException extends RuntimeException {

	/**
	 *
	 */
	@Serial
	private static final long serialVersionUID = 7191937019817926918L;

	public OperationTypeNotFoundException(String message) {
		super(message);
	}
}