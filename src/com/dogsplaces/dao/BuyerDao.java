package com.dogsplaces.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dogsplaces.model.Buyer;
import com.dogsplaces.util.JPAUtil;

public class BuyerDao {
	
	public void addBuyer(Buyer buyer) {
		EntityManager em;
		EntityTransaction tx; 
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		tx.begin();
		em.persist(buyer);
		tx.commit();
		em.close();
	}

}
