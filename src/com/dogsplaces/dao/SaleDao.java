package com.dogsplaces.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dogsplaces.model.Sale;
import com.dogsplaces.util.JPAUtil;


public class SaleDao {

	
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
