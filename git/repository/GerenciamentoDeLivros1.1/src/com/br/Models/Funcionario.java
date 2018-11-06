package com.br.Models;

public class Funcionario extends Usuario{
	
	private String matricula;
	private String cpf;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula){
		this.matricula = toString();
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String string) {
		this.cpf = string;
	}
}
