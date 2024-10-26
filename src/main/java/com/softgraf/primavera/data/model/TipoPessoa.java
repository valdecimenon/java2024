package com.softgraf.primavera.data.model;

public enum TipoPessoa {
	
	FISICA("Física", GrupoCpf.class),
	JURIDICA("Jurídica", GrupoCnpj.class);
	
	private final String descricao;
	private final Class<?> grupo;
	
	// construtor do enum
	private TipoPessoa(String descricao, Class<?> grupo) {
		this.descricao = descricao;
		this.grupo = grupo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public Class<?> getGrupo() {
		return grupo;
	}
}
