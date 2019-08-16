package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dogsplaces.model.Sale;
import com.dogsplaces.util.JPAUtil;


public class SaleDao {

	private Connection connection;
	
	public SaleDao(Connection connection) {
		this.connection = connection;
	}

	// TODO: Inserir itens do carrinho de compras imediatamente
	
	public void addSale(Sale sale) {
		EntityManager em;
		EntityTransaction tx; 
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(sale);
		tx.commit();
		em.close();
	}
}
