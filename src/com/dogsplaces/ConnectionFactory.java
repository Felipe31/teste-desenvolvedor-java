package com.dogsplaces;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/dogsplaces", "dogsadmin", "password");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
