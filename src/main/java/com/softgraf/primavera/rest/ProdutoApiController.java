package com.softgraf.primavera.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softgraf.primavera.data.dto.ProdutoRecordDTO;
import com.softgraf.primavera.entity.Produto;
import com.softgraf.primavera.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class ProdutoApiController {

	@Autowired // faz a implementação e injeção do repositório
	private ProdutoRepository repository;
	
	// cria uma rota HTTP para acesso via Post
	// localhost:8080/api/cadastrar
//	@PostMapping("cadastrar")
//	public void cadastrar(@RequestBody String json) {
//		System.out.println(json);
//	}
	
	@PostMapping("cadastrar")
	public Produto cadastrar(@RequestBody Produto produto) {
		return repository.save(produto);
	}
	
	// Lista todos os produtos
	// GET: localhost:8080/api/listar
	// curl -v localhost:8080/api/listar
	// Retorna um array de objetos JSON
	@GetMapping("listar")
	public List<Produto> listarTodos(){
		return repository.findAll();
	}
	
	// Busca um produto por id
	// GET: localhost:8080/api/produto/1
	// curl -v localhost:8080/api/produto/1
	// Retorna um OBJETO JSON ou erro 404 com mensagem
	@GetMapping("/produto/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}         
	
	// Atualiza ou Salva um único produto
	// PUT: localhost:8080/api/produto/2
	// Retorna o mesmo objeto JSON enviado com id
	@PutMapping("produto/{id}")
	public Produto atualizarPorId(@RequestBody @Valid ProdutoRecordDTO produtoDTO, @PathVariable Long id) {
		return repository.findById(id).map(p -> {
			// atualiza
			p.setDescricao(produtoDTO.descricao());
			p.setPreco(produtoDTO.preco());
			p.setQuantidade(produtoDTO.quantidade());
			p.setUrlImagem(produtoDTO.urlImagem());		
			return repository.save(p);	
			
		}).orElseGet(() -> {
			// salva
			return repository.save(produtoDTO.toProduto());
		});
	}
	
	// Apaga produto por id
	// DELETE: localhost:8080/api/produto/2
	// curl -v localhost:8080/api/produto/2
	// Sem retorno
	@DeleteMapping("produto/{id}")
	public void deletarPorId(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	
}