package jpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private BigDecimal preco;

	public Produto() {

	}
	
	// construtor com argumentos
	public Produto(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}
	


	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank(message =  "Nome do produto está em branco")
	@Size(min=4, max=45)
	@Column(length = 45, nullable = false)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull(message = "Faltou o preço")
	@DecimalMin(value = "0.00", message = "Produto abaixo do preço mínimo")
	@DecimalMax(value = "9999", message = "Produto acima do preço máximo")
	// 12345.12
	@Column(nullable = false, precision = 5, scale = 2)
	public BigDecimal getPreco() {
		return preco;
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}

	
}
