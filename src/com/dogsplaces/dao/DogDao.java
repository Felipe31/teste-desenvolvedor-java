package com.dogsplaces.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dogsplaces.model.Dog;
import com.dogsplaces.util.JPAUtil;

public class DogDao {
	
	public DogDao() {}
	
	public List<Dog> searchDog(String breed) {
		EntityManager em = JPAUtil.getEntityManager();
		
		Query q = em.createQuery("select d from Dog d where d.breed.name like :breedName", Dog.class);
		q.setParameter("breedName", "%" + breed + "%");
		
		return q.getResultList();
	}
	
	public Dog getDog(int id) {
	
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select d from Dog d where d.id = :dogId", Dog.class);
		q.setParameter("dogId", id);

		return (Dog) q.getResultList().get(0);
	
	}

	public List<Dog> getDogList() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select d from Dog d", Dog.class);
		return q.getResultList();
	}
}
