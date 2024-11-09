package com.softgraf.primavera.service;

import org.springframework.stereotype.Service;

import com.softgraf.primavera.entity.Produto;
import com.softgraf.primavera.repository.ProdutoRepository;

@Service
public class CrudService {

	private final ProdutoRepository produtoRepository;
	
	public CrudService(ProdutoRepository produtoRepository) {
		System.out.println("Construtor do CrudService");
		this.produtoRepository = produtoRepository;
	}
	
	public void cadastra3Produtos() {
		Produto p1 = new Produto("Xarope para Tosse", 35.99f, 10);
		Produto p2 = new Produto("Shampoo Anticaspa", 49.99f, 15);
		Produto p3 = new Produto("Anti inflamatório", 5.65f, 20);
		
		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		
		System.out.println("=== Produtos Salvos ====");
	}
	
	public void cadastraNovoProduto() {
		
	}
	
	public void listaTodosProdutos() {
		
	}
	
	public void buscaPorDescricao() {
		
	}
	
	private String randomTexto(int tamanho) {
			return null;
	}
	
	public void cadastra100Produtos() {
		
	}
	
	public void listaProdutosComPaginacao(String campo) {
		System.out.println("\n\n==== Listando Todos os Produtos ====");
		produtoRepository.findAll().forEach(System.out::println);
	}
}
