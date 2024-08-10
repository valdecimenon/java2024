package com.softgraf.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.softgraf.util.JpaUtil;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Named;

// Bean CDI
@Named  // anotação do CDI
public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;
	
	// construytor padrão
	public UsuarioRepository() {
		// temporário
		this.em = JpaUtil.getEntityManager();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("\nInicializou bean CDI UsuarioRepository...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("\nDestruiu bean CDI UsuarioRepository...");
	}
	
	public boolean autenticar(String nomeUsuario, String senha) {
		// retorna Boolean true ou false
		String jpql = "select count(u) > 0 from Usuario u where nome=?1 and senha=?2";
		TypedQuery<Boolean> query = em.createQuery(jpql, Boolean.class);
		query.setParameter(1, nomeUsuario);
		query.setParameter(2, senha);
		return query.getSingleResult();  // retorna true ou false	
	}
	

}
