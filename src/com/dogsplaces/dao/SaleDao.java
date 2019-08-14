package com.dogsplaces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dogsplaces.model.Sale;


public class SaleDao {

	private Connection connection;
	
	public SaleDao(Connection connection) {
		this.connection = connection;
	}

	// TODO: Inserir itens do carrinho de compras imediatamente
	
	public void addSale(Sale sale) {
		String sql = "insert into Sale " +
				"(buyerId,finished)" +
				" values (?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, sale.getBuyerId());
			stmt.setBoolean(2, sale.isFinished());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateSale(Sale sale) {
		String sql = "update Sale set" +
				"buyerId = ?, " +
				"finished = ? " +
				"where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, sale.getBuyerId());
			stmt.setBoolean(2, sale.isFinished());
			stmt.setInt(3, sale.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
