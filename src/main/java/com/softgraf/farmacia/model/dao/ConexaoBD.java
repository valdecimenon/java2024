package com.softgraf.farmacia.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	private String urlConexao = "jdbc:sqlite:estoque.db";
	
	public Connection conectar() {
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(urlConexao);
			System.out.println("Conectou....");
			
		} catch (SQLException e) {
			System.out.println("Erro de conexão com o banco de dados SQLite");
			e.printStackTrace();
		}
		return conexao;
	}
	
	public boolean fecharConexao(Connection conexao) {
		boolean fechou = false;
		
		try {
			
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
				System.out.println("Fechou a conexão");
				fechou = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexão com o banco de dados");
			e.printStackTrace();
		}
		
		return fechou;
	}
}
