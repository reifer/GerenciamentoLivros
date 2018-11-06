package com.br.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConnection {



	public static Connection getConnection () throws SQLException{

	    try{

	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Conectando ao banco !!!!!!...!");

	        return

	        DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciamentodelivros", "root", "1234");

	    }catch (ClassNotFoundException e){

	        throw new SQLException (e.getMessage());

	    }

	}

}