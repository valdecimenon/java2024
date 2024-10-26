package com.softgraf.primavera.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// quando um ProdutoNotFoundException for lançado o Spring MVC renderiza um erro HTTP 404
@ControllerAdvice
public class ProdutoNotFoundAdvice {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProdutoNotFoundException.class)
	@ResponseBody
	String produtoNotFoundHandler(ProdutoNotFoundException ex) {
		return ex.getMessage();
	}
}
