package com.global.exception;

public class UnauthoriseException extends Exception 
{

	private static final long serialVersionUID=84253614158l;
	
	public UnauthoriseException() {
		super();
	}
	
	public UnauthoriseException(String message)
	{
		super(message);
	}
}

