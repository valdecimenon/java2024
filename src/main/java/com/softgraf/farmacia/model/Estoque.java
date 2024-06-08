package com.softgraf.farmacia.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estoque {

	private List<Produto> lista;
	private static Estoque estoque = null;
	
	private Estoque() {
		lista = new ArrayList<>();
	}
	
	// padrão Singleton
	public static Estoque getInstancia() {
		if (estoque == null) {
			estoque = new Estoque();
		}
		
		return estoque;
	}
	
	
	public boolean addProduto(Produto p) {
		
		return lista.add(p);
	}
	
	public boolean removeProduto(Produto p) {
		
		return lista.remove(p);
	}
	
	public boolean removeProduto(String codigo) {
		
		for (Produto p : lista) {
			if (p.getCodigo().equalsIgnoreCase(codigo)) {
				lista.remove(p);
				return true;
			}
		}
		
		return false;
	}
	
	public List<Produto> listaProdutos(){
		return Collections.unmodifiableList(lista);
	}
	
	public int getQuantidade() {
		return lista.size();
	}
	
	public boolean isVazio() {
		return lista.isEmpty();
	}
}
