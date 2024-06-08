package com.softgraf.farmacia.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softgraf.farmacia.model.Produto;

public class ProdutoDAO implements AbstractGenericDAO<Produto>{

	private Connection conexao;
	
	// construtor que recebe uma conexão do banco
	public ProdutoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void criarTabela() throws SQLException {
		
		String sql = "CREATE TABLE IF NOT EXISTS Produto (" +
				   		"codigo VARCHAR(14)," +
				   		"descricao VARCHAR(255)," +
				   		"preco DECIMAL(10, 2) " +
				   	 ")";
		
		// try with resources
		try (Statement stmt = conexao.createStatement()) {
			stmt.execute(sql);
			System.out.println("Tabela produto criada.");
			
		} catch (SQLException e) {
			System.out.println("Erro ao criar tabela Produto.");
			e.printStackTrace();
			throw e;
		}
	}
	
	public long ultimoId() throws SQLException {
		String sql = "SELECT last_insert_rowid() as id FROM Produto";
		
		Statement stmt = conexao.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			long id = rs.getLong("id");
			rs.close();
			stmt.close();
			return id;
			
		} else {
			throw new SQLException("Não foi possível obter last_insert_rowid()");
		}
	}
	
	
	@Override
	public boolean inserir(Produto p) {
		
		String sql = "INSERT INTO Produto (codigo, descricao, preco) VALUES (?, ?, ?)";
		boolean retorno = false;
		
		// try with resources
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getDescricao());
			stmt.setFloat(3, p.getPrecoUnitario());
			stmt.executeUpdate();
			System.out.println("Produto inserido: " + p.getDescricao());
			long id = ultimoId();
			p.setId(id);
			retorno = true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir produto");
			e.printStackTrace();
		}
		
		
		return retorno;
	}

	@Override
	public void remover(Produto p) {
		remover(p.getId());
	}

	@Override
	public void remover(Long id) {
		String sql = "DELETE FROM Produto WHERE rowid=?";
		
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao remover produto");
			e.printStackTrace();
		}
	}
	
	public void removerPorCodigo(String codigo) {
		String sql = "DELETE FROM Produto WHERE codigo=?";
		
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, codigo);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao remover produto por código");
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Produto p) {
		String sql ="UPDATE Produto SET codigo=?, descricao=?, preco=? WHERE rowid=?";
		
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, p.getCodigo());
			stmt.setString(2, p.getDescricao());
			stmt.setFloat(3, p.getPrecoUnitario());
			stmt.setLong(4, p.getId());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar produto");
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> listar() {
		
		String sql = "SELECT rowid, codigo, descricao, preco from Produto";
		List<Produto> lista = new ArrayList<Produto>();
		
		try (Statement stmt = conexao.createStatement()){
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				long id = rs.getLong("rowid");
				String codigo = rs.getString("codigo");
				String descricao = rs.getString("descricao");
				float preco = rs.getFloat("preco");
				
				Produto p = new Produto(codigo, descricao, preco);
				p.setId(id);
				
				lista.add(p);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar produtos");
			e.printStackTrace();
		}
		
		return lista;
	}

}
