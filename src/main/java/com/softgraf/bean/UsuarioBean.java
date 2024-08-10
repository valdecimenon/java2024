package com.softgraf.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/* Escopos (tempo de vida do bean CDI):
 * RequestScoped - escopo de requisição = existe somente durante a requisição 
 * SessionScoped - escopo de sessão = enquanto a sessão existir
 * ApplicationScoped - escopo de aplicação = enquanto a aplicação estiver aberta (no backend)
 */

// Bean CDI
@Named
// Escopo de Sessão = bean existe enquanto a sessão estiver ativa
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private LocalDateTime dataLogin;
	
	public boolean isLogado() {
		return nome != null;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDateTime getDataLogin() {
		return dataLogin;
	}
	
	public void setDataLogin(LocalDateTime dataLogin) {
		this.dataLogin = dataLogin;
	}

}
