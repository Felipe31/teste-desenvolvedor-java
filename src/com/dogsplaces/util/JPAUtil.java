package com.dogsplaces.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dogsplaces-db");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
