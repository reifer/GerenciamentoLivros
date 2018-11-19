package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	//private static final String JDBC_URL ="jdbc:mysql://127.0.0.1:54748/localdb";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros?useTimezone=true&serverTimezone=UTC";
	private static final String JDBC_USER = "root";
	//private static final String JDBC_USER = "azure";
	private static final String JDBC_PASS = "reifer";
	//private static final String JDBC_PASS = "6#vWHD_$";
	private Connection con;

	public UsuarioDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e1) {
			throw new GenericDaoException(e1);
		}
	}

	@Override
	public void adiciona(Usuario u) throws GenericDaoException {
		String sql = "INSERT INTO usuario VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getSenha());
			stmt.setInt(5, u.getTipo());
			stmt.setString(6, u.getTelefone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public Usuario pesquisarPorId(int id) throws GenericDaoException {
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuario WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setTelefone(rs.getString("telefone"));
				u.setTipo(rs.getInt("tipo"));

			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		return u;
	}

	@Override
	public List<Usuario> getAllUser() throws GenericDaoException {
		List<Usuario> lista = new ArrayList<>();
		String sql = "SELECT id, nome FROM usuario ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Usuario s = new Usuario();
				s.setId(rs.getInt("id"));
				s.setNome(rs.getString("nome"));
				lista.add(s);
			}
		} catch (SQLException e) {
			throw new GenericDaoException(e);
		}
		return lista;
	}

	@Override
	public void editar(Usuario u) throws GenericDaoException {
		System.out.println(u.getNome());
		String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, tipo= ?, telefone = ?  WHERE id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getSenha());
			stmt.setInt(4, u.getTipo());
			stmt.setString(5, u.getTelefone());
			stmt.setInt(6, u.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void remover(int id) throws GenericDaoException {
		String sql = "DELETE FROM usuario WHERE id = ? ";
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public Usuario login(String user, String pass) throws GenericDaoException {
		Usuario u = new Usuario();
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setTipo(rs.getInt("tipo"));
			}
		} catch (SQLException e) {
			throw new GenericDaoException(e);
		}
		return u;
	}
}