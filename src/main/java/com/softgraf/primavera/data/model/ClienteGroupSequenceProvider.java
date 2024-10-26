package com.softgraf.primavera.data.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.softgraf.primavera.entity.Cliente;

// Faz a associação entre Pessoa Física com CPF e Pessoa Jurídica com CNPJ
public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {

	@Override
	public List<Class<?>> getValidationGroups(Cliente cliente) {
		List<Class<?>> grupos = new ArrayList<>();
		
		if (cliente != null && cliente.getTipoPessoa() != null) {
			grupos.add(cliente.getTipoPessoa().getGrupo());
		}
		
		return grupos;
	}

}
