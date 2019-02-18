package com.comdata.posa.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetDBConnection {
	
	private static Connection connection = null;
	
	public static Connection getConnection(String url, String userName, String password)
			throws Exception {
		if(connection == null) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, userName, password);

		} catch (Exception Ex) {			
			Ex.printStackTrace();
			throw Ex;
		}
		}

			return connection;


	}
}
