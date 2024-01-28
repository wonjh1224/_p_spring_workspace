//package com.myweb.www.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@ControllerAdvice
//public class CommonExceptionAdvice {
//
//	@ExceptionHandler(Exception.class)
//	public String exception(Exception ex) {
//		log.info("@@ exception > {}", ex.getMessage());
//		return "error";
//	}
//	
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	@ExceptionHandler(NoHandlerFoundException.class)
//	public String hadler404(NoHandlerFoundException ex) {
//		log.info("@@ 404 exception > {}", ex.getMessage());
//		return "custom404";
//	}
//}
