package com.softgraf.primavera.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Anotações do Lombok
@NoArgsConstructor  // cria o construtor padrão

@Getter   // cria todos os getters
@Setter   // cria todos os setters
@EqualsAndHashCode
@ToString


// @Data = junção de: @Getter + @Setter +  @EqualsAndHashCode + @ToString

// Anotações JPA
@Table(name="produtos")
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 2733608659158775825L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "Descrição do produto é obrigatório")  // Validation
	@Column(length = 60, nullable = false)
	private String descricao;
	
	@DecimalMin(value="0.0", inclusive = false, message = "Preço abaixo do mínimo")
	@DecimalMax(value = "9999.0", message = "Preço acima do máximo")
	@Column(nullable = false)
	private Float preco;
	
	@NotNull(message = "Quantidade é obrigatória")
	@Min(1)
	@Max(9999)
	@Column(nullable = false)
	private Integer quantidade;

	@Column(length = 60)
	private String urlImagem;

	// construtor 3 parâmetros
	public Produto(String descricao, Float preco, Integer quantidade) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	// construtor 4 parâmetros
	public Produto(Long id, String descricao, Float preco, Integer quantidade) {
		this(descricao, preco, quantidade);
		this.id = id;
	}

	// construtor 4 parâmetros
	public Produto(String descricao, Float preco, Integer quantidade, String urlImagem) {
		this(descricao, preco, quantidade);
		this.urlImagem = urlImagem;
	}
	
}
