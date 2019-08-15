package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.dogsplaces.model.Breed;
import com.dogsplaces.model.Dog;
import com.dogsplaces.util.JPAUtil;

public class DogDao {

	private Connection connection;
	
	public DogDao() {}
	
	public DogDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<Dog> searchDog(Breed breed) {
		String sql = "select * from Dog " +
				"where breedId = ?";
		
		try {
			List<Dog> dogs = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, breed.getId());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Dog dog = new Dog();
				
				dog.setId(rs.getInt("id"));
				dog.setBreedId(rs.getInt("breedId"));
				dog.setAge(rs.getInt("age"));
				dog.setCoatColor(rs.getString("coatColor"));
				dog.setGender(rs.getString("gender").charAt(0));
				dog.setSold(rs.getBoolean("sold"));
				
				dogs.add(dog);
			}
			
			rs.close();
			stmt.close();
			
			return dogs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Dog getDog(int id) {
		String sql = "select * from Dog " +
				"where id = ?";

		try {

			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Dog dog = new Dog();
			if (rs.next()) {
				dog.setId(rs.getInt("id"));
				dog.setBreedId(rs.getInt("breedId"));
				dog.setAge(rs.getInt("age"));
				dog.setCoatColor(rs.getString("coatColor"));
				dog.setGender(rs.getString("gender").charAt(0));
				dog.setSold(rs.getBoolean("sold"));
			}
			
			return dog;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateDog(Dog dog) {
		String sql = "update Dog set" +
				"breedId = ?, " +
				"age = ?, " +
				"coatColor = ?, " +
				"gender = ?, " +
				"sold = ? " +
				"where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, dog.getId());
			stmt.setInt(2, dog.getBreedId());
			stmt.setInt(3, dog.getAge());
			stmt.setString(4, dog.getCoatColor());
			stmt.setString(5, String.valueOf(dog.getGender()));
			stmt.setBoolean(6, dog.getSold());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Dog> getDogList() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select d from Dog d", Dog.class);
		return q.getResultList();
	}
}
