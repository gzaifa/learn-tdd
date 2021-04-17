package com.sg.gzf.learn.tdd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car not found!", value = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
