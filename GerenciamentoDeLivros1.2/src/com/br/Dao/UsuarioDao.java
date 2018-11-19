package com.br.Dao;


import java.util.List;

import com.br.Models.Usuario;

public interface UsuarioDao {
	public void adiciona(Usuario u) throws GenericDaoException;
	public void remover(int id) throws GenericDaoException;
	public void editar(Usuario u) throws GenericDaoException;
	public Usuario pesquisarPorId(int id) throws GenericDaoException;
	public List<Usuario> getAllUser() throws GenericDaoException;
	public Usuario login(String user, String pass) throws GenericDaoException;
}
