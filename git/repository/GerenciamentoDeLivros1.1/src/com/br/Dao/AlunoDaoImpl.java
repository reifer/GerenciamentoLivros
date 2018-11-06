package com.br.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.Models.Aluno;
//import com.br.connectionFactory.ConnectionFactory;

public class AlunoDaoImpl implements AlunoDao {
	private Connection connect;

	@Override
	public void alterar(int Ra, Aluno aluno) throws GenericDaoException{
		String sql = "UPDATE GERENCIAMENTODELIVROS SET ALUNO"
				+ "NOME = ?, Email = ?, Tipo = ?, Telefone = ?, Curso = ?, "
				+ "RA = ? WHERE RA = ?";
		try {
			PreparedStatement smt = connect.prepareStatement(sql);
			smt.setInt(1, aluno.getId());
			smt.setString(2, aluno.getNome());
			smt.setString(3, aluno.getEmail());
			smt.setString(4, aluno.isTipo());
			smt.setString(5, aluno.getTelefone());
			smt.setLong(6, aluno.getRa());
			smt.setString(7, aluno.getCurso());
			smt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
	}

	@Override
	public void adiciona(Aluno aluno) throws GenericDaoException {
		String sql = "INSERT INTO ALUNO VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement smt = connect.prepareStatement(sql);
			smt.setInt(1, aluno.getId());
			smt.setString(2, aluno.getNome());
			smt.setString(3, aluno.getEmail());
			smt.setString(4, aluno.isTipo());
			smt.setString(5, aluno.getTelefone());
			smt.setLong(6, aluno.getRa());
			smt.setString(7, aluno.getCurso());
			smt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}

		
	}

	@Override
	public void remover(int Ra) throws GenericDaoException{
		String sql = "DELETE FROM ALUNO WHERE RA = ?";
		try {
			PreparedStatement smt = connect.prepareStatement(sql);
			smt.setInt(1, Ra);
			smt.executeUpdate();
		} catch (SQLException e) {
			throw new GenericDaoException();
		}
		
	}

	@Override
	public List<Aluno> pesquisarRA(int Ra) throws GenericDaoException{
		List<Aluno> lista = new ArrayList<>();
		String sql = "SELECT * FROM ALUNO WHERE RA = ?";
		try{
			PreparedStatement smt = connect.prepareStatement(sql);
			smt.setInt(1, Ra);
			ResultSet rs = smt.executeQuery();
			while(rs.next()){
				Aluno a = new Aluno();
				a.setId(rs.getInt("Id"));
				a.setNome(rs.getString("Nome"));
				a.setEmail(rs.getString("Email"));
				a.setTipo(rs.getString("Tipo"));
				a.setTelefone(rs.getString("Telefone"));
				a.setRa(rs.getInt("Ra"));
				a.setCurso(rs.getString("Curso"));
				lista.add(a);
			}
		}
			catch(SQLException e){
				throw new GenericDaoException();
		}
		return lista;
	}
	
	
}
