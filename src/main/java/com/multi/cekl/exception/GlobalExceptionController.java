package com.multi.cekl.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.multi.cekl.response.CustomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


@ControllerAdvice
public class GlobalExceptionController {
	
	 private static Logger log = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	 @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	    public ResponseEntity<CustomResponse> handleError405(HttpServletRequest request, Exception e, HttpServletResponse res) {
	       CustomResponse customResponse = new CustomResponse("405", "Bad request!");
	       log.error("Error code 405 {} ",e.getLocalizedMessage());
	        return new ResponseEntity<>(customResponse, HttpStatus.OK);
	    }
	 
	 @ExceptionHandler(MissingServletRequestPartException.class)
	    public ResponseEntity<CustomResponse> handleMissingServletRequest(HttpServletRequest request, Exception e, HttpServletResponse res) {
	       CustomResponse customResponse = new CustomResponse("400", e.getLocalizedMessage());
	       log.error("Error code 400 {} ",e.getLocalizedMessage());
	        return new ResponseEntity<>(customResponse, HttpStatus.OK);
	    }
	 
	 @ExceptionHandler( java.net.ConnectException.class)
	    public ResponseEntity<CustomResponse> handleConnectionException(HttpServletRequest request, Exception e, HttpServletResponse res) {
	       CustomResponse customResponse = new CustomResponse("501", e.getLocalizedMessage());
	       log.error("Error code 501 {} ",e.getLocalizedMessage());
	        return new ResponseEntity<>(customResponse, HttpStatus.OK);
	    }
	 
	 @ExceptionHandler(java.sql.SQLSyntaxErrorException.class)
	    public ResponseEntity<CustomResponse> handleRequestOracleException(HttpServletRequest request, Exception e, HttpServletResponse res) {
	       CustomResponse customResponse = new CustomResponse("500", "Error, Database internal server error occured!");
	       log.error("Error code 500 {} ",e.getLocalizedMessage());
	        return new ResponseEntity<>(customResponse, HttpStatus.OK);
	    }

	@ExceptionHandler(org.springframework.web.client.ResourceAccessException.class)
	public ResponseEntity<CustomResponse> handleRequestResourceNet(HttpServletRequest request, Exception e, HttpServletResponse res) {
		CustomResponse customResponse = new CustomResponse("501", e.getLocalizedMessage());
		log.error("Error code 501 {} ",e.getLocalizedMessage());
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}

	@ExceptionHandler(java.net.UnknownHostException.class)
	public ResponseEntity<CustomResponse> handleRequestResourceResolveDomain(HttpServletRequest request, Exception e, HttpServletResponse res) {
		CustomResponse customResponse = new CustomResponse("501", e.getLocalizedMessage());
		log.error("Error code 501 {} ",e.getLocalizedMessage());
		return new ResponseEntity<>(customResponse, HttpStatus.OK);
	}
}
