package cubes.main.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<MessageResponse> handleException(Exception exception) {
		
		MessageResponse response = new MessageResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MessageResponse> handleException(CategoryException exception) {
		
		MessageResponse response = new MessageResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
