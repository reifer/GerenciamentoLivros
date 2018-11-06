package com.br.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Funcionario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FuncionarioDaoImpl implements FuncionarioDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "reifer";
	private Connection con;

	public FuncionarioDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void adiciona(Funcionario f) throws GenericDaoException {
		String sql = "INSERT INTO funcionarios ()" + "VALUES(?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setLong(1, 0);
			stmt.setString(2, f.getNome());
			stmt.setString(3, f.getEmail());
			stmt.setString(4, f.getTelefone());
			stmt.setString(5, f.getCpf());
			stmt.setString(6, f.getMatricula());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public List<Funcionario> pesquisarPorMatricula(String matricula) throws GenericDaoException {
		List<Funcionario> lista = new ArrayList<>();
		String sql = "SELECT * FROM funcionarios WHERE matricula like ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, "%" + matricula + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getString("telefone"));
				f.setCpf(rs.getString("cpf"));
				f.setTipo(rs.getString("tipo"));
				lista.add(f);
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return lista;
	}

	@Override
	public void remover(String matricula) throws GenericDaoException {
		String sql = "DELETE FROM funcionarios WHERE matricula = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, matricula);
			stmt.executeLargeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void salvar(int matricula, Funcionario f) throws GenericDaoException {
		String sql = "UPDATE funcionarios SET nome = ?, email = ?, telefone = ?, cpf = ? " + "WHERE matricula = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEmail());
			stmt.setString(3, f.getTelefone());
			stmt.setString(4, f.getCpf());
			stmt.setLong(5, matricula);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}
	//verificar
	@Override
	public List<Funcionario> adiciona(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	//verificar
	@Override
	public void salvar(String matricula, Funcionario nome) throws GenericDaoException {
		// TODO Auto-generated method stub
		
	}
}