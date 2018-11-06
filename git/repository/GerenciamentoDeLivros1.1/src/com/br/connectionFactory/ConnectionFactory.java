package com.br.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.br.connectionFactory.ConnectionFactory;

public class ConnectionFactory {

	private final static String URL = ("jdbc:mysql://localhost:3306/gerenciamentodelivros");
	private final static String User = ("root");
	private final static String Password = ("1234");

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, User, Password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Fechando conexão
	public static void closeConnection(Connection connect) {
		{
			try {
				if (connect != null)
					connect.close();

			} catch (SQLException e) {
				Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
}