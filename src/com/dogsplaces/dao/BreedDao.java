package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dogsplaces.model.Breed;

public class BreedDao {

	private Connection connection;
	
	public BreedDao(Connection connection) {
		this.connection = connection;
	}

	public List<Breed> getBreedList() {
		try {
			List<Breed> breeds = new ArrayList<>();
			String sql = "select * from Breed";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Breed breed = new Breed();
				
				breed.setId(rs.getInt("id"));
				breed.setCoatLength(rs.getString("coatLength"));
				breed.setDescription(rs.getString("description"));
				breed.setHeight(rs.getFloat("height"));
				breed.setWeight(rs.getFloat("weight"));				
								
				breeds.add(breed);
			}
			
			rs.close();
			stmt.close();
			
			return breeds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
