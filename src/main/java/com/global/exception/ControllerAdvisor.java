package com.global.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor {

	
	//Handling Global Exceptions
   @ExceptionHandler(BadRequestException.class)
   public ResponseEntity<Object> handleBadRequestException(BadRequestException ex)
   {
	   Map<String,Object> map=new LinkedHashMap<String,Object>();
	   map.put("timestamp", LocalDateTime.now());
	   map.put("message",ex.getMessage());
	   ex.printStackTrace();
	   
	   return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
   }
   
   
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<?> handlingResourceNotFound(ResourceNotFoundException ex, WebRequest webRequest)
   {
	   Map<String,Object> map=new LinkedHashMap<String,Object>();
	   map.put("message", "Resource not found");
	   return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(FileNotFoundException.class)
   public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException ex, WebRequest request,HttpServletRequest httpRequest) 
   {
		Map<String, Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		ex.printStackTrace();
		
		return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
   }
   
   
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handaleException(Exception ex, WebRequest request,HttpServletRequest httpRequest){
		
		Map<String, Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		//body.put("message", "Server error, Please contact IT Team");
		body.put("message", "Something wrong, Please contact Admin or Teams");
		ex.printStackTrace();
		
		return new ResponseEntity<Object>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
   
	
	@ExceptionHandler(StorageException.class)
	public ResponseEntity<Object> handaleStorageException(StorageException ex, WebRequest request,HttpServletRequest httpRequest){
		
		Map<String, Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		ex.printStackTrace();
		
		return new ResponseEntity<Object>(body, HttpStatus.INSUFFICIENT_STORAGE);
		
	}
	
	@ExceptionHandler(UnauthoriseException.class)
	public ResponseEntity<Object> handaleUnauthoriseException(UnauthoriseException ex, WebRequest request,HttpServletRequest httpRequest){
		
		Map<String, Object> body=new LinkedHashMap<String, Object>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		ex.printStackTrace();
		
		return new ResponseEntity<Object>(body, HttpStatus.UNAUTHORIZED);
		
	}
   
   
   

	
}


