package com.br.Dao;

import java.util.List;

import com.br.Models.Emprestimo;

public interface EmprestimoDao {
	public void adiciona(Emprestimo e) throws GenericDaoException;

	public List<Emprestimo> pesquisaPorAluno(int raAluno) throws GenericDaoException;

	public void remover(long id) throws GenericDaoException;

	public Emprestimo pesquisarPorId(long id) throws GenericDaoException;

	public void salvar(long id, Emprestimo e) throws GenericDaoException;
}