package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dogsplaces.model.Breed;

public class BreedDao {

	private Connection connection;
	
	public BreedDao(Connection connection) {
		this.connection = connection;
	}

	
	public Breed getBreed(int id) {
		String sql = "select * from Breed " +
				"where id = ?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Breed breed = new Breed();

			breed.setId(rs.getInt("id"));
			breed.setName(rs.getString("name"));
			breed.setCoatLength(rs.getString("coatLength"));
			breed.setDescription(rs.getString("description"));
			breed.setHeight(rs.getFloat("height"));
			breed.setWeight(rs.getFloat("weight"));				

			return breed;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Breed> getBreedList() {
		String sql = "select * from Breed";

		try {
			List<Breed> breeds = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Breed breed = new Breed();
				
				breed.setId(rs.getInt("id"));
				breed.setName(rs.getString("name"));
				breed.setCoatLength(rs.getString("coatLength"));
				breed.setDescription(rs.getString("description"));
				breed.setHeight(rs.getFloat("height"));
				breed.setWeight(rs.getFloat("weight"));				
								
				breeds.add(breed);
			}
			
			rs.close();
			stmt.close();
			
			return breeds;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Breed> searchBreed(String breedname) {
		String sql = "select * from Breed " +
				"where name like '%?%'";

		try {
			List<Breed> breeds = new ArrayList<>();
			
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, breedname);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Breed breed = new Breed();
				
				breed.setId(rs.getInt("id"));
				breed.setName(rs.getString("name"));
				breed.setCoatLength(rs.getString("coatLength"));
				breed.setDescription(rs.getString("description"));
				breed.setHeight(rs.getFloat("height"));
				breed.setWeight(rs.getFloat("weight"));				
								
				breeds.add(breed);
			}
			
			rs.close();
			stmt.close();
			
			return breeds;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
