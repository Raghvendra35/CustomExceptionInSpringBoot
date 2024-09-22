package com.global.exception;

public class FileNotFoundException extends StorageException 
{

	public FileNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

    public FileNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	 }
}
