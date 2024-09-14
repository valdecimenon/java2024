package jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1583861589775174818L;
	private Integer id;
	private String nome;
	private Endereco endereco;
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	// ALT SHIFT S => Constructor
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	// ALT SHIFT S => Constructor
	public Cliente(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// bean validation
	@NotBlank(message = "Nome do cliente está em branco")
	@Size(min = 3, max = 45) 
	@Column(length = 45, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@OneToOne(cascade = CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// hashCode e Equals: id, nome
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	// ALT SHIFT S -> toString
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", endereco=" + endereco + "]";
	}	
	
}
