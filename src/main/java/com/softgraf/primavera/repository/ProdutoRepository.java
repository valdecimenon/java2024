package com.softgraf.primavera.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softgraf.primavera.entity.Produto;

@Repository  // estereótipo opcional
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	 // cache opcional
	 @Cacheable("descricao_produto")  // nome do cache = qualquer
	 // método personalizado: Containing similar a 'like' do SQL
	 // findBy + nome do campo + Containing
	 List<Produto> findByDescricaoContaining(String descricao);
	
}
