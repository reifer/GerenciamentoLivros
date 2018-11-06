package com.br.Models;

import java.util.Date;

public class Emprestimo {
	private int IdLivro;
	private int RaAluno;
	private Date DataInicioEmp;
	private Date DataFimEmp;
	private long SetId;
	private long Id;

	public long getSetId() {
		return SetId;
	}

	public void setSetId(long setId) {
		SetId = setId;
	}

	public long getId() {
		return Id;
	}

	public int getIdLivro() {
		return IdLivro;
	}

	public void setIdLivro(int idLivro) {
		IdLivro = idLivro;
	}

	public int getRaAluno() {
		return RaAluno;
	}

	public void setRaAluno(int raAluno) {
		RaAluno = raAluno;
	}

	public Date getDataInicioEmp() {
		return DataInicioEmp;
	}

	public void setDataInicioEmp(Date dataInicioEmp) {
		DataInicioEmp = dataInicioEmp;
	}

	public Date getDataFimEmp() {
		return DataFimEmp;
	}

	public void setDataFimEmp(Date dataFimEmp) {
		DataFimEmp = dataFimEmp;
	}

	public void setId(long setId) {
		SetId = setId;

	}
}