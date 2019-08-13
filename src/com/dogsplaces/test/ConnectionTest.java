package com.dogsplaces.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.dogsplaces.ConnectionFactory;

public class ConnectionTest {

	
	public static void main(String[] args) {
		
		try (Connection connection = new ConnectionFactory().getConnection()) {
			System.out.println("Connected to DB!");
		} catch (SQLException e) {

		}
		
	}
	
}
