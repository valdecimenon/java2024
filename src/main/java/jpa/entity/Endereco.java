package jpa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 8233747619170637757L;
	private Integer id;
	private String rua;
	private String cidade;
	private String uf;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	// construtor
	// ALT SHIFT S
	public Endereco(String rua, String cidade, String uf) {
		this.rua = rua;
		this.cidade = cidade;
		this.uf = uf;
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

	@Column(length = 45)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@NotBlank(message = "Nome da cidade está em branco")
	@Size(min = 3, max = 20)
	@Column(length = 20, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	@NotBlank(message = "Nome do estado está em branco")
	@Size(min = 2, max = 2)
	@Column(length = 2, nullable = false)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		return Objects.equals(id, other.id) && Objects.equals(rua, other.rua);
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", cidade=" + cidade + ", uf=" + uf + "]";
	}
	
	

}
