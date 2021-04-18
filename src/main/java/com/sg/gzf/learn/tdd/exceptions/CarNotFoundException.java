package com.sg.gzf.learn.tdd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "Car could not be found.")
public class CarNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
