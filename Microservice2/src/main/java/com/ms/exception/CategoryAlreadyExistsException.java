package com.ms.exception;

public class CategoryAlreadyExistsException extends RuntimeException {

	public CategoryAlreadyExistsException(String msg) {
		super(msg);
	}
}
