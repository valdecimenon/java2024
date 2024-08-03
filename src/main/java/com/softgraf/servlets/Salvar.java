package com.softgraf.servlets;


import java.io.IOException;
import java.time.LocalDate;

import com.softgraf.entity.Aluno;
import com.softgraf.repository.AlunoRepository;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/salvar")
public class Salvar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoRepository alunoRepository;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno aluno = new Aluno();
		aluno.setNome(request.getParameter("nome"));
		aluno.setCurso(request.getParameter("curso"));
		
		// data formato string: "20/07/2024"
		String sData = request.getParameter("data");
		
		// converte string em formato LocalDate
		if (sData.isEmpty())
			aluno.setData(null);
		else
			aluno.setData(LocalDate.parse(sData));
		
		aluno.setEmail(request.getParameter("email"));
		
		System.out.println("Persistindo aluno...");
		alunoRepository.adicionar(aluno);
		
		response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
