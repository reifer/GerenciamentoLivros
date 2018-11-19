package com.br.Models;

public class Livro {
	private int Id;
	private String Nome = "";
	private String Genero = "";
	private String Autor = "";
	private String Editora = "";
	private boolean Status;
	
	public int getId() {
		return Id;
	}
	public void setId(int l) {
		Id = l;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero(String genero) {
		Genero = genero;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getEditora() {
		return Editora;
	}
	public void setEditora(String editora) {
		Editora = editora;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setSatus(boolean status) {
		this.Status = status;
	}
	

}
