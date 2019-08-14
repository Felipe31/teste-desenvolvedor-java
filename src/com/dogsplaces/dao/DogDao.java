package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dogsplaces.model.Dog;

public class DogDao {

	private Connection connection;
	
	public DogDao(Connection connection) {
		this.connection = connection;
	}

	public List<Dog> getDogList() {
		
		try {
			List<Dog> dogs = new ArrayList<>();
			String sql = "select * from Dog";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Dog dog = new Dog();
				
				dog.setId(rs.getInt("id"));
				dog.setBreedId(rs.getInt("breedId"));
				dog.setAge(rs.getInt("age"));
				dog.setCoatColor(rs.getString("coatColor"));
				dog.setGender(rs.getString("gender").charAt(0));				
								
				dogs.add(dog);
			}
			
			rs.close();
			stmt.close();
			
			return dogs;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
