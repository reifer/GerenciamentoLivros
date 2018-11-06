package com.br.Dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Usuario;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDaoImpl implements UsuarioDao {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "reifer";
	private Connection con;

	public UsuarioDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void adiciona(Usuario u) throws GenericDaoException {
		String sql = "INSERT INTO usuarios ()" + "VALUES(?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setLong(1, 0);
			stmt.setInt(2, u.getId());
			stmt.setString(3, u.getNome());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getTelefone());
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void remover(String nome) throws GenericDaoException {
		String sql = "DELETE FROM usuarios WHERE nome = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void salvar(String nome) throws GenericDaoException {
		String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ? " + "WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			Usuario u = new Usuario();
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getTelefone());
			//stmt.setInt(4, u.getId());
			//stmt.setBoolean(5, u.getTipo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public List<Usuario> pesquisarporId(int Id) throws GenericDaoException {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT * FROM usuarios WHERE id like ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, "%" + Id + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setTelefone(rs.getString("telefone"));
				//u.setInt(rs.getString("id"));
				//u.setTipo(rs.getBoolean("tipo"));
				lista.add(u);
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return null;
	}
	//verificar
	@Override
	public List<Usuario> pesquisarporId(String id) throws GenericDaoException {
		// TODO Auto-generated method stub
		return null;
	}
	//verificar
	@Override
	public List<Usuario> adiciona(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}