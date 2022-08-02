package com.durgesh.cog.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.cog.response.RestApiErrorResponseMessage;

@RestController
@ControllerAdvice
public class RestApiExceptionHandler {
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<RestApiErrorResponseMessage> resourceNotFoundException(){
		
		RestApiErrorResponseMessage error=new RestApiErrorResponseMessage(400,"Peope not found with id", new Date());
		
		return new   ResponseEntity<RestApiErrorResponseMessage>(error,HttpStatus.BAD_REQUEST);
		
	}

@ExceptionHandler(value=BodyNotFoundException.class)
public ResponseEntity<RestApiErrorResponseMessage> bodyNotFoundException(){
	
	RestApiErrorResponseMessage error=new RestApiErrorResponseMessage(400," Body Required", new Date());
	
	return new ResponseEntity<RestApiErrorResponseMessage>(error,HttpStatus.BAD_REQUEST);
	
}
	

}
