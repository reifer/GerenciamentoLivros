package com.br.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.br.Models.Emprestimo;

public class EmprestimoDaoImpl implements EmprestimoDao{
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gerenciamentodelivros";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "1234";
	private Connection con;
	
	public EmprestimoDaoImpl() throws GenericDaoException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		}catch (SQLException | ClassNotFoundException e) {
			throw new GenericDaoException( );
		}
	}

	@Override
	public void adiciona(Emprestimo e) throws GenericDaoException {
		String sql = "INSERT INTO emprestimo (id, idlivro, raaluno, datainicioemp, datafimemp)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 0);
			pstmt.setInt(2, e.getIdLivro());
			pstmt.setInt(3, e.getRaAluno());
			pstmt.setDate(4, (java.sql.Date) e.getDataInicioEmp());
			pstmt.setDate(5, (java.sql.Date) e.getDataFimEmp());
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
	}

	@Override
	public List<Emprestimo> pesquisaPorAluno(int raAluno) throws GenericDaoException {
		List<Emprestimo> lista = new ArrayList<>();
		String sql = "SELECT * FROM emprestimo WHERE raaluno like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, raAluno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Emprestimo e = new Emprestimo();
				e.setId(rs.getLong("id"));
				e.setIdLivro(rs.getInt("idLivro"));
				e.setRaAluno(rs.getInt("raAluno"));
				e.setDataInicioEmp(rs.getDate("dataInicioEmp"));
				e.setDataFimEmp(rs.getDate("dataFimEmp"));
				lista.add(e);
			}
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		
		return lista;
	}

	@Override
	public void remover(long id) throws GenericDaoException {
		String sql = "DELETE FROM emprestimo WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		
	}

	@Override
	public Emprestimo pesquisarPorId(long id) throws GenericDaoException {
		Emprestimo e = new Emprestimo();
		String sql = "SELECT * FROM emprestimo WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				e.setId(rs.getLong("id"));
				e.setIdLivro(rs.getInt("idLivro"));
				e.setRaAluno(rs.getInt("raAluno"));
				e.setDataInicioEmp(rs.getDate("dataInicioEmp"));
				e.setDataFimEmp(rs.getDate("dataFimEmp"));
			}
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
		return e;
	}

	@Override
	public void salvar(long id, Emprestimo e) throws GenericDaoException {
		String sql = "UPDATE emprestimo SET idLivro = ?, raAluno = ?, dataInicioEmp = ?, dataFimEmp = ?"
				+ "WHERE id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getIdLivro());
			pstmt.setInt(2, e.getRaAluno());
			pstmt.setDate(3, (java.sql.Date) e.getDataInicioEmp());
			pstmt.setDate(4, (java.sql.Date) e.getDataFimEmp());
			pstmt.setLong(5, id);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			throw new GenericDaoException();
		}
	}

}
