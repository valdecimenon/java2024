package com.softgraf.farmacia.model;

import java.util.Objects;

/**
 * 
 */
public class Endereco {

	private long id;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(String rua, String cidade, String estado, String cep) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	

	public String getRua() {
		return rua;
	}

	public Endereco rua(String rua) {
		this.rua = rua;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Endereco cidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getEstado() {
		return estado;
	}

	public Endereco estado(String estado) {
		this.estado = estado;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public Endereco cep(String cep) {
		this.cep = cep;
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return id == other.id && Objects.equals(rua, other.rua);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep
				+ "]";
	}
}
