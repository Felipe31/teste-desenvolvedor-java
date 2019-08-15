package com.dogsplaces.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dogsplaces.model.Dog;

public class PersistenceTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dogsplaces-db");
		EntityManager em = emf.createEntityManager();
		
		Dog dog = new Dog();
		dog.setAge(6);
		dog.setBreedId(2);
		dog.setCoatColor("white");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(dog);
		tx.commit();
		
		em.close();
		emf.close();

	}

}
