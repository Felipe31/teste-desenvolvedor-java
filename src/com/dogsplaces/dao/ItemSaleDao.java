package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dogsplaces.model.ItemSale;

public class ItemSaleDao {

private Connection connection;
	
	public ItemSaleDao(Connection connection) {
		this.connection = connection;
	}
	
	public void addItemSale(ItemSale itemSale) {
		String sql = "insert into ItemSale " +
				"(saleId,dogId)" +
				" values (?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, itemSale.getSaleId());
			stmt.setInt(2, itemSale.getDogId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateSale(ItemSale itemSale) {
		String sql = "update ItemSale set" +
				"dogId = ? " +
				"where saleId = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, itemSale.getDogId());
			stmt.setInt(2, itemSale.getSaleId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
