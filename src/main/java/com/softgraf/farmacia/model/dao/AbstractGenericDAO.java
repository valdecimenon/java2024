package com.softgraf.farmacia.model.dao;

import java.util.List;

/*
 * DAO é um padrão de projeto
 * DAO (Data Access Object) = Objeto de Acesso à Dados
 */

public interface AbstractGenericDAO<T> {

	boolean inserir(T entidade);
	
	void remover(T entidade);
	
	void remover(Long id);
	
	void atualizar(T entidade);
	
	List<T> listar();
}
