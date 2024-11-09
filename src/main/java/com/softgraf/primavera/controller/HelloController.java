package com.softgraf.primavera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class HelloController {

	
	// localhost:8080/hello
	// Este método é uma Action = método para atender uma requisição HTTP
	// Aqui recebe um ServletRequest como parâmetro
	
	// Define a rota do método GET
	/*
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome", "João da Silva");
		return "bemvindo";  // retorna o nome da página HTML
	}
	*/
	
	
	// aqui recebe um objeto Model do Spring, como parâmetro
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("nome", "João da Silva");
		// redireciona para uma view chamada "templates/bemvindo.html"
		return "bemvindo";
	}
	
	
	
}
