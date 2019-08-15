package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dogsplaces.model.Buyer;

public class BuyerDao {
	
	private Connection connection;
	
	public BuyerDao(Connection connection) {
		this.connection = connection;
	}

	public Buyer searchBuyer(String cpf) {
		String sql = "select * from Buyer " +
				"where cpf = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			Buyer buyer = new Buyer();
			
			buyer.setId(rs.getInt("id"));
			buyer.setName(rs.getString("name"));
			buyer.setCpf(rs.getString("cpf"));
			buyer.setEmail(rs.getString("email"));
			buyer.setAddress(rs.getString("address"));
			
			return buyer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Buyer getBuyer(int id) {
		String sql = "select * from Buyer " +
				"where id = ?";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Buyer buyer = new Buyer();
			
			buyer.setId(rs.getInt("id"));
			buyer.setName(rs.getString("name"));
			buyer.setCpf(rs.getString("cpf"));
			buyer.setEmail(rs.getString("email"));
			buyer.setAddress(rs.getString("address"));
			
			return buyer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void addBuyer(Buyer buyer) {
		String sql = "insert into Buyer " +
				"(name,cpf,email,address)" +
				" values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, buyer.getName());
			stmt.setString(2, buyer.getCpf());
			stmt.setString(3, buyer.getEmail());
			stmt.setString(4, buyer.getAddress());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void updateBuyer(Buyer buyer) {
		String sql = "update Buyer set" +
				"name = ?, " +
				"cpf = ? " +
				"email = ?, " +
				"address = ? " +
				"where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, buyer.getName());
			stmt.setString(2, buyer.getCpf());
			stmt.setString(3, buyer.getEmail());
			stmt.setString(4, buyer.getAddress());
			stmt.setInt(5, buyer.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
