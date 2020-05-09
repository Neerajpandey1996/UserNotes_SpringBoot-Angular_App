package com.neeraj.UserNotesSpringBootApp.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler 
{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) 
	{

		CustomErrorDetail customError=new CustomErrorDetail();
		customError.setTimestamp(new Date());
		customError.setError("Some Error occor");
	customError.setErrorDetail(ex.getMessage());
	
	return new ResponseEntity<>(customError,HttpStatus.BAD_REQUEST);
	
	}
	
	
	
	@ExceptionHandler(CategoryIdNotFoundException.class)
	public final ResponseEntity<Object> handleIdNotFoundException(CategoryIdNotFoundException exception , WebRequest webrequest)
	{
		CustomErrorDetail customError=new CustomErrorDetail();
		
		customError.setTimestamp(new Date());
		customError.setError("Some Error occor");
		customError.setErrorDetail(exception.getMessage());
		
		return new ResponseEntity<>(customError,HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(NotesIdNotFoundException.class)
	public final ResponseEntity<Object> handleNotesIDNotFoundException(NotesIdNotFoundException notesIdnotFound , WebRequest request)
	{
CustomErrorDetail customError=new CustomErrorDetail();
		
		customError.setTimestamp(new Date());
		customError.setError("Some Error occor");
		customError.setErrorDetail(notesIdnotFound.getMessage());
		
		return new ResponseEntity<>(customError,HttpStatus.NOT_FOUND);
	}
	

}
