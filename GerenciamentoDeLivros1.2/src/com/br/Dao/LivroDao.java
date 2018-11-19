package com.br.Dao;

import java.util.List;

import com.br.Models.Livro;

public interface LivroDao {
	public void adiciona(Livro l) throws GenericDaoException;
	public List<Livro> getAll() throws GenericDaoException;
	//public void remover(int id) throws GenericDaoException;
	public void remover(int id) throws GenericDaoException;
	public Livro pesquisarPorId(int id) throws GenericDaoException;
	public void editar( Livro l) throws GenericDaoException;
}
