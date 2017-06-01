package br.com.caelum.contas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection conn;
	private static final String URL = "jdbc:postgresql://localhost/sistema";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	
	public Connection getConnection() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
			
		} catch (SQLException | ClassNotFoundException e) {
			
			throw new SQLException(e);
		}
		
		return conn;
	}

}
