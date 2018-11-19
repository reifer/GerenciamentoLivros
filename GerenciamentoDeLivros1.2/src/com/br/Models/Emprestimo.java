package com.br.Models;

public class Emprestimo {
	private int Id;
	private int IdLivro;
	private int IdUsuario;
	
	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		this.Id = id;
	}

	public int getIdLivro() {
		return IdLivro;
	}

	public void setIdLivro(int idLivro) {
		IdLivro = idLivro;
	}

}