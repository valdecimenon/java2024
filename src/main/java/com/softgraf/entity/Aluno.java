package com.softgraf.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  // será a tabela Aluno do banco
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id  // chave primária
	@GeneratedValue  // auto incremento
	private Integer id;
	
	@Column(length = 45)
	private String nome;
	
	@Column(length = 20)
	private String curso;
	
	@Column(length = 60)
	private String email;
	
	private LocalDate data;

	// getters e setters: ALT SHIFT S
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
		
}


