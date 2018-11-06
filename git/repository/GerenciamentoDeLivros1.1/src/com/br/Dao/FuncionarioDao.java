package com.br.Dao;

import java.util.List;

import com.br.Models.Funcionario;

public interface FuncionarioDao {
	public void adiciona(Funcionario f) throws GenericDaoException;
	public List<Funcionario> pesquisarPorMatricula(String matricula) throws GenericDaoException; //verificar
	public void remover(String matricula) throws GenericDaoException;
	public void salvar(String matricula, Funcionario nome) throws GenericDaoException;
	public List<Funcionario> adiciona(String cpf);//verificar
	void salvar(int matricula, Funcionario f) throws GenericDaoException;//verificar
}
