package com.softgraf.primavera.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Anotações Lombok
@NoArgsConstructor
@Getter
@Setter
@ToString

// Anotação do JPA
@Embeddable  // incorporável ou imbutível
public class Endereco {

	@Column(length = 30)
	private String rua;
	
	@Column(length = 20)
	private String bairro;
	
	@NotBlank(message = "Cidade é obrigatório")
	@Size(min = 3, max = 30)
	@Column(length = 30, nullable = false)
	private String cidade;
	
	@NotBlank(message = "Estado  é obrigatório")
	@Column(length = 20, nullable = false)
	private String estado;
	
	@Column(length = 9)
	private String cep; 
	
}
