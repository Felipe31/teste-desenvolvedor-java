package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dogsplaces.model.ItemSale;

public class ItemSaleDao {

private Connection connection;
	
	public ItemSaleDao(Connection connection) {
		this.connection = connection;
	}
	
	public List<ItemSale> getItemsSale(int saleId) {
		String sql = "select * from ItemSale " +
				"where saleId = ?";
		
		try {
			List<ItemSale> itemsSale = new ArrayList<>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, saleId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ItemSale itemSale = new ItemSale();
				
				itemSale.setSaleId(rs.getInt("saleId"));
				itemSale.setDogId(rs.getInt("dogId"));				
				
				itemsSale.add(itemSale);
			}
			
			rs.close();
			stmt.close();
			
			return itemsSale;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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
