package com.softgraf.farmacia.model;

import java.util.Objects;

// java bean
public class Produto  {

	private long id;   // id único do banco de dados
	private String codigo;
	private String descricao;
	private float precoUnitario;

	
	// construtor padrão
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	// construtor com 3 parâmetros
	// ALT SHIFT S => Generate Constructor using Fields
	public Produto(String codigo, String descricao, float precoUnitario) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
		
	// ALT SHIFT S => Generate Getters and Setters
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	// ALT SHIFT S => Generate hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao);
	}

	// ALT SHIFT S => toString
	@Override	
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", precoUnitatio="
				+ precoUnitario + "]";
	}

}
