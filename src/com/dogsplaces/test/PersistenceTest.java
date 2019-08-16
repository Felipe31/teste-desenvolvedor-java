package com.dogsplaces.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dogsplaces.model.Breed;
import com.dogsplaces.model.Dog;
import com.dogsplaces.util.JPAUtil;

public class PersistenceTest {

	public static void main(String[] args) {
		EntityManager em;
		EntityTransaction tx; 
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		Breed breed1 = new Breed();
		breed1.setName("Yorkshire Terrier");
		breed1.setHeight((float)9);
		breed1.setWeight((float)6);
		breed1.setDescription("Small in size but big in personality, the Yorkshire Terrier makes a feisty but loving companion.");
		breed1.setCoatLength("Long");
		tx.begin();
		em.persist(breed1);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		Breed breed2 = new Breed();
		breed2 = new Breed();
		breed2.setName("Beagle");
		breed2.setHeight((float)15);
		breed2.setWeight((float)30);
		breed2.setDescription("Small, compact, and hardy, Beagles are active companions for kids and adults alike.");
		breed2.setCoatLength("Short");
		tx.begin();
		em.persist(breed2);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		Breed breed3 = new Breed();
		breed3 = new Breed();
		breed3.setName("German Shepherd Dog");
		breed3.setHeight((float)26);
		breed3.setWeight((float)95);
		breed3.setDescription("The German Shepherd Dog is one of America's most popular dog breeds' for good reason.");
		breed3.setCoatLength("Medium");
		tx.begin();
		em.persist(breed3);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		Dog dog = new Dog();
		dog.setAge(6);
		dog.setBreed(breed3);
		dog.setCoatColor("white");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		tx.begin();
		em.persist(dog);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		dog = new Dog();
		dog.setAge(4);
		dog.setBreed(breed1);
		dog.setCoatColor("black");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		tx.begin();
		em.persist(dog);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		dog = new Dog();
		dog.setAge(6);
		dog.setBreed(breed2);
		dog.setCoatColor("white");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		tx.begin();
		em.persist(dog);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		dog = new Dog();
		dog.setAge(4);
		dog.setBreed(breed3);
		dog.setCoatColor("black");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		tx.begin();
		em.persist(dog);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		dog = new Dog();
		dog.setAge(6);
		dog.setBreed(breed2);
		dog.setCoatColor("white");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		tx.begin();
		em.persist(dog);
		tx.commit();
		em.close();
		
		em = JPAUtil.getEntityManager();
		tx = em.getTransaction();
		dog = new Dog();
		dog.setAge(4);
		dog.setBreed(breed2);
		dog.setCoatColor("black");
		dog.setGender('M');
		dog.setPrice((float)200.59);
		dog.setSold(false);
		tx.begin();
		em.persist(dog);
		tx.commit();
		em.close();


	}

}
