package com.mil0812.learnspring.persistence.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
	private ConnectionManager() {
	}
	private static final String URL_KEY = "db.url";
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
