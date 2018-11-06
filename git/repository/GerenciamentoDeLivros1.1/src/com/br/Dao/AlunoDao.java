package com.br.Dao;

import java.util.List;

import com.br.Models.Aluno;

public interface AlunoDao {

	public void adiciona(Aluno aluno) throws GenericDaoException;

	public void alterar(int Ra, Aluno a) throws GenericDaoException;

	public void remover(int Ra) throws GenericDaoException;

	public List<Aluno> pesquisarRA(int Ra) throws GenericDaoException;
}