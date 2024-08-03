package com.softgraf.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  // cria a tabela usuário
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Em Mysql:
	 * CREATE TABLE Usuario (
	 *     ID INT PRIMARY KEY AUTO_INCREMENT
	 * )
	 */
	@Id   // chave primaria
	@GeneratedValue  // auto increment
	private Integer id;
	
	@Column(length = 45)
	private String nome;
	
	@Column(length = 255)
	private String senha;

	// getters e setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// hashcode e equals: id, nome
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}	
}
