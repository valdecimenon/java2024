package jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 7303574306867570344L;
	
	private Integer id;
	private Produto produto;
	private Pedido pedido;
	private Integer quantidade;
	
	public Item() {
	
	}

	public Item(Produto produto, Pedido pedido, Integer quantidade) {
		this.produto = produto;
		this.pedido = pedido;
		this.quantidade = quantidade;
	}

	// getters e setters
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Min(value = 1, message = "Quantidade mínima do produto deve ser 1")
	@Max(value = 99, message = "Quantidade máxima do produto deve ser 99")
	@Column(nullable = false)
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(pedido, other.pedido)
				&& Objects.equals(produto, other.produto);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", produto=" + produto + ", pedido=" + pedido + ", quantidade=" + quantidade + "]";
	}
		

}
