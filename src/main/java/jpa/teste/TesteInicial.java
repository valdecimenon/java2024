package jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jpa.entity.Cliente;
import jpa.entity.Endereco;
import jpa.entity.Item;
import jpa.entity.Pedido;
import jpa.entity.Produto;
import jpa.util.JpaUtil;

// BLOB = Binary Large Object = imagens, objetos java, etc
public class TesteInicial {

	public static void main(String[] args) {
		Endereco ruaXV = new Endereco("XV", "Ponta Grossa", "PR");
		Cliente joao = new Cliente("João da Silva", ruaXV);
		Cliente rafael = new Cliente("Rafael Justus", ruaXV);

		Produto banana = new Produto("banana", new BigDecimal("5.99"));
		Produto bolacha = new Produto("bolacha", new BigDecimal("10.99"));
		
		Pedido ped1 = new Pedido(joao);
		Pedido ped2 = new Pedido(rafael);
		
		joao.addPedido(ped1);
		rafael.addPedido(ped2);
		
		Item item1 = new Item(banana, ped1, 10);
		Item item2 = new Item(bolacha, ped1, 5);
		ped1.addItem(item1);
		ped1.addItem(item2);
					
		ped2.addItem(item2);
		
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(joao);
		em.persist(rafael);
		tx.commit();
		
		JpaUtil.close();

	}

}
