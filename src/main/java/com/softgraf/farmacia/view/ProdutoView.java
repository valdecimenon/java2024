package com.softgraf.farmacia.view;

import com.softgraf.farmacia.model.Produto;

public class ProdutoView {

	private ProdutoView() {};
	
	public static Produto cadastrar() {
		
		System.out.println("---- Cadastro de Produto -----");
		
		String codigo = Teclado.lerString("Código do produto: ");
		String descricao = Teclado.lerLinha("Descrição do produto: ");
		float preco = Teclado.lerFloat("Preço do produto: ");
		
		Produto p = new Produto(codigo, descricao, preco);
		
		return p;
	}
	
}
