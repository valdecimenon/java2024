package com.softgraf.farmacia.controller;

import java.sql.Connection;
import java.sql.SQLException;

import com.softgraf.farmacia.model.dao.ConexaoBD;
import com.softgraf.farmacia.model.dao.ProdutoDAO;

import static com.softgraf.farmacia.view.Teclado.*;

public class Principal {

	public static void main(String[] args) throws SQLException {
	
		
		ConexaoBD bd = new ConexaoBD();
		Connection conexao = bd.conectar();
		
		ProdutoDAO dao = new ProdutoDAO(conexao);
		dao.criarTabela();
	
		int opcao = 0;
		
		do {
		
			msg("====== Sistema de Farmácia V 1.0 ========");
			msg("1 = Cadastrar produto");
			msg("2 = Cadastrar cliente");
			msg("3 = Cadastrar pedido");
			msg("9 = Sair do sistema");
			
			opcao = lerInt("Escolha:");
			
			// CONTINUA...
		
		} while (opcao != 9);
		
		
		
		
		bd.fecharConexao(conexao);
		

	}

}
