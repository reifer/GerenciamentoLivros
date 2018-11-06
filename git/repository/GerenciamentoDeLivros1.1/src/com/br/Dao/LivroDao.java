package com.br.Dao;

import java.util.List;

import com.br.Models.Livro;

public interface LivroDao {
	public void adiciona(Livro l) throws GenericDaoException;
	public List<Livro> pesquisarPorAutor(String autor) throws GenericDaoException;
	public void remover(long id) throws GenericDaoException;
	public Livro pesquisarPorId(long id) throws GenericDaoException;
	public void salvar(long id, Livro l) throws GenericDaoException;
}
