package com.global.exception;

public class InternalServerError extends Exception
{

	String message;
	public InternalServerError() {
		super();
	}
	public InternalServerError(String message) {
		super(message);
		this.message=message;
	}
}
