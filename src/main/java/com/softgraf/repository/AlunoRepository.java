package com.softgraf.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.softgraf.entity.Aluno;
import com.softgraf.util.JpaUtil;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import teste.Teste;

/*
 * Um repositório representa uma coleção de objetos de um tipo específico.
 * É um mediador entre a camada de negócios e  acesso a dados.
 * Deve fornecer métodos para adicionar, remover, atualizar, buscar, etc.
 */

@Named  // anotação do CDI => bean CDI
public class AlunoRepository {

	// gerenciador de entidades JPA (container JPA)
	private EntityManager em;
	
	
	// construtor padrão - usado pelo CDI
	public AlunoRepository() {
		// temporário
		this.em = JpaUtil.getEntityManager();
	}
	
	// construtor que recebe um entity manager
	public AlunoRepository(EntityManager em) {
		this.em = em;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("\nInicializou bean CDI AlunoRepository...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("\nDestruiu bean CDI AlunoRepository...");
	}
	
	
	public void adicionar(Aluno aluno) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(aluno);
		tx.commit();
		
		System.out.println(Teste.nomeUsuario);
	}
	
	public void removerPorId(Integer id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// torna a entidade gerenciada (estado Managed)
		Aluno aluno = em.find(Aluno.class, id);
		em.remove(aluno);
		tx.commit();
	}
	
	public void atualizar(Aluno aluno) {
		
	}
	
	public Aluno buscarPorId(Integer id) {
		
		return null;
	}
	
	public List<Aluno> getTodos(){
		// JPQL = Java Persistence Query Language
		TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
		List<Aluno> lista = query.getResultList();
		return lista;
	}
	
}
