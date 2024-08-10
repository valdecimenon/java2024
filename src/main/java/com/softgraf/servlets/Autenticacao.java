package com.softgraf.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import com.softgraf.bean.UsuarioBean;
import com.softgraf.repository.UsuarioRepository;

import jakarta.inject.Inject;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class Autenticacao implements Filter {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private UsuarioBean usuarioBean;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Inicializando o filtro");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { 
		
		System.out.println("\n===== doFilter() iniciado");
		
		// converte (casting) ServletRequest (classe mãe) para HttpServletRequest (classe filha)
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// obtém a sessão atual ou null
		HttpSession session = req.getSession(false);  // false = não criar sessão
				
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		System.out.println("Nome: " + nome + " - Senha: " + senha);
		
		// já está logado
		if (session != null && session.getAttribute("login") != null) {
			// carrega a página solicitada
			chain.doFilter(req, res);
			
		// não está logado e requisição vem da tela de login
		} else if (nome != null && senha != null && usuarioRepository.autenticar(nome, senha)) {
			// cria a sessão
			session = req.getSession(true);
			// salva o login na sessão
			session.setAttribute("login", nome);
			usuarioBean.setNome(nome);
			usuarioBean.setDataLogin(LocalDateTime.now());
			// carrega a página solicitada
			chain.doFilter(req, res);
			
		// não está logado, carrega a tela de login
		} else {
			
			// reencaminha a requisição
			req.getRequestDispatcher("/login.jsp").forward(req, res);			
		}
		
		System.out.println("\n===== doFilter() finalizado");
	}
	
	@Override
	public void destroy() {
		System.out.println("\nFiltro destroy()");
		Filter.super.destroy();
	}
}
