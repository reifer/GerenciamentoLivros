package com.br.connectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TesteConDao {
	
	private Connection connection;

	public TesteConDao() throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona() {
		String sql = "insert into livro (nome, numero) values('História de Futebol', 3)";
		//String sql1 = "insert into livro (nome, numero) values('avatar',4)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			//PreparedStatement stmt1 = connection.prepareStatement(sql1);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}