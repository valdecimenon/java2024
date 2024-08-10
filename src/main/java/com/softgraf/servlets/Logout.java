package com.softgraf.servlets;

import java.io.IOException;

import com.softgraf.bean.UsuarioBean;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBean usuarioBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// obtém a sessão atual ou null
		HttpSession session = req.getSession();
		if (session != null) {
			session.invalidate();  // finaliza a sessão e o login
			usuarioBean.setNome(null);
			usuarioBean.setDataLogin(null);
			// solicita ao navegador para carregar login.jsp
			resp.sendRedirect("/login.html");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
