package com.br.Dao;

import java.util.List;

import com.br.Models.Usuario;

public interface UsuarioDao {
	public void adiciona(Usuario u) throws GenericDaoException;
	public void remover(String nome) throws GenericDaoException;
	public void salvar(String nome) throws GenericDaoException;
	public List<Usuario> pesquisarporId(String id) throws GenericDaoException;
	public List<Usuario> adiciona(String string);//Verificar
	List<Usuario> pesquisarporId(int Id) throws GenericDaoException;
}
