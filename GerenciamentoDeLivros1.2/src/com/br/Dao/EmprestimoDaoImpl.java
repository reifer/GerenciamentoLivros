package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Emprestimo;
import com.br.Models.Livro;

public class EmprestimoDaoImpl implements EmprestimoDao {

	private static final String JDBC_URL ="jdbc:mysql://127.0.0.1:3306/localdb";
	//private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros?useTimezone=true&serverTimezone=UTC";
	//private static final String JDBC_USER = "root";
	private static final String JDBC_USER = "azure";
	//private static final String JDBC_PASS = "reifer";
	private static final String JDBC_PASS = "6#vWHD_$";
	private Connection con;

	public EmprestimoDaoImpl() throws GenericDaoException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void adiciona(Emprestimo e) throws GenericDaoException {
		String sql = "INSERT INTO emprestimo (id, idlivro, idUsuario)" + "VALUES (?, ?, ?)";

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, e.getIdLivro());
			pstmt.setInt(3, e.getIdUsuario());
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
		this.alterarStatusLivro(e.getIdLivro());
	}
	
	public void devolver(Emprestimo e) throws GenericDaoException {
		String sql = "DELETE FROM emprestimo WHERE idLivro = ? AND idUsuario = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getIdLivro());
			pstmt.setInt(2, e.getIdUsuario());
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
		this.alterarStatusLivroDevol(e.getIdLivro());
	}

	private void alterarStatusLivro(int idLivro) throws GenericDaoException {
		String sql = "UPDATE livro SET status = 1 WHERE idlivro = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idLivro);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
	}
	
	private void alterarStatusLivroDevol(int idLivro) throws GenericDaoException {
		String sql = "UPDATE livro SET status = 0 WHERE idlivro = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idLivro);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
	}

	@Override
	public List<Livro> pesquisaPorAluno(int id) throws GenericDaoException {
		List<Livro> lista = new ArrayList<>();
		String sql = "select t2.* from emprestimo as t1 inner join livro as t2 on t1.idLivro = t2.idlivro where idUsuario = ?;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Livro l = new Livro();
				l.setId(rs.getInt("idlivro"));
				l.setNome(rs.getString("nome"));
				l.setGenero(rs.getString("genero"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
				lista.add(l);
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}

		return lista;
	}

}
