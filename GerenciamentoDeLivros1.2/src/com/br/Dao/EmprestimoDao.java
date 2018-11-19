package com.br.Dao;

import java.util.List;

import com.br.Models.Emprestimo;
import com.br.Models.Livro;

public interface EmprestimoDao {
	public void adiciona(Emprestimo e) throws GenericDaoException;
	public void devolver(Emprestimo e) throws GenericDaoException;
	public List<Livro> pesquisaPorAluno(int id) throws GenericDaoException;
}