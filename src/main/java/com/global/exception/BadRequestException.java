package com.global.exception;

public class BadRequestException extends Exception 
{

	private static final long serialVersionUID=82525412541278L;
	String message;
	public BadRequestException()
	{
		super();
	}
	
	public BadRequestException(String message)
	{
		super(message);
		this.message=message;
	}
	
	public BadRequestException(Exception ex) {
		super(ex);
	}
	
}
