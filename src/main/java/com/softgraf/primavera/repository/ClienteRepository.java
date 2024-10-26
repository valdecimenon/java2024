package com.softgraf.primavera.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softgraf.primavera.entity.Cliente;
import com.softgraf.primavera.projection.ClienteProjection;

import jakarta.persistence.NamedQuery;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	// ======== Exemplo Métodos personalizados =======
	// 1. Like
	// "SELECT * from Cliente WHERE nome LIKE %maria%"
	// "%maria%"
	List<Cliente> findByNomeLike(String nome);
	
	// 2. Containing
	// String nome = "maria"
	List<Cliente> findByNomeContaining(String nome);
	List<Cliente> findByEmailContaining(String nome);
	
	// 3. Starting / Ending
	// String 
	List<Cliente> findByNomeStartingWith(String nome);
	List<Cliente> findByNomeEndingWith(String nome);
	
	// Null ou Not Null
	List<Cliente> findByNomeIsNull();
	List<Cliente> findByNomeIsNotNull();
	
	// Busca  com ordenação
	List<Cliente> findByNomeOrderByNomeAsc(String nome);
	List<Cliente> findByNomeOrderByNomeDesc(String nome);
	
	// Busca com ordenação usando Sort
	// Sort sort = Sort.by(Sort.Direction.ASC, "nome")
	List<Cliente> findByNomeContaining(String nome, Sort sort);
	
	// Busca com classe aninhada
	List<Cliente> findByEndereco_RuaContaining(String rua);
	List<Cliente> findByEndereco_CidadeContaining(String cidade);
	
	// Busca com paginação e ordenação -  interface PaginAndSortingRepository
	// JpaRepository extends PagingAndSortingRepository
	//                                   page size sort
	// Pageable pageable = PageRequest.of(1,   5,  Sort.by(Sort.Direction.ASC, 'email')
	Page<Cliente> findAll(Pageable pageable);
	
	
	 // === Queries usando JPA ====
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Pageable pageable);
	
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente")
	List<Cliente> findAllByNome(@Param("nomeCliente") String nomeCliente, Sort sort);
	
	// query usando nome e data (atributo fictício)
	// Formatador de data: DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy")
	// LocalDate data = LocalDate.parse("19/10/2024", formatador)
	// @Query("SELECT c FROM Cliente WHERE c.nome = :nome AND c.dataCadastro = :data")
	// List<Cliente> findByNomeDataCadastro(@Param("nome") String nome, @Param("data") LocalDate data);
	

	// ==== Queries usando SQL nativo = Native Queries ====
	// Exemplo em MySQL
	@Query(value = "SELECT * FROM Cliente WHERE nome = ?1", nativeQuery=true)
	List<Cliente> findByNome(String nome);
	
	// query usando Interface-Based Projection
	// equivale no JPA ao operador "Select New pacote.ClienteProjecao(c.id, c.nome, c.email) FROM Cliente c"
	@Query (value="SELECT c.id, c.nome, c.email FROM Cliente c", nativeQuery=true)
	// ClienteProjection é uma interface
	List<ClienteProjection> findClienteProjecao();
	
	
	// === JPA Named' Queries ===
	// Nome dos métodos deve equivaler ao nome das named queries implementadas na entidade	
	List<Cliente> buscarPF(@Param("cpf") String cpf);
	List<Cliente> buscarPJ(@Param("cnpj") String cnpj);
	
	// https://baeldung.com/spring-data-jpa-query
	
}



