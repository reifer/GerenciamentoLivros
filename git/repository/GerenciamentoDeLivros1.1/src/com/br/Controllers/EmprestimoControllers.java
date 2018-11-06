package com.br.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.EmprestimoDao;
import com.br.Dao.GenericDaoException;
import com.br.Models.Emprestimo;

public class EmprestimoControllers extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public EmprestimoControllers(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter()
		.append("Para acessar utilize a pegina de <a href=\"./emprestimo.jsp\">emprestimo</a>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		try{
			Emprestimo eDao = new Emprestimo();
			if ("adicionar".equals(cmd)){
				Emprestimo e = new Emprestimo();
				e.setIdLivro(Integer.parseInt(request.getParameter("txtIdLivro")));
				e.setRaAluno(Integer.parseInt(request.getParameter("txtRaAluno")));
				String dataIni = request.getParameter("txtDataInicioEmp");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				try{
					Date dataEparse = (Date) sdf.parse(dataIni);
					e.setDataInicioEmp(dataEparse);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}
				String dataFim = request.getParameter("txtDataFimEmp");
				try {
					Date dataFparse = (Date) sdf.parse(dataFim);
					e.setDataFimEmp(dataFparse);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}
			} else if("pesquisar".equals(cmd)){
				List<Emprestimo> lista = ((EmprestimoDao) eDao).pesquisaPorAluno(
						Integer.getInteger(request.getParameter("txtRaAluno")));
				session.setAttribute("LISTA", lista);
				msg = "Foram encontrados" + lista.size() + " Emprestimos do aluno";
			} else if("remover".equals(cmd)){
				String id = request.getParameter("txtId");
				((EmprestimoDao) eDao).remover(Long.parseLong(id));
				msg = "Emprestimo com Id" + id + "foi removido";
				List<Emprestimo> lista = ((EmprestimoDao) eDao).pesquisaPorAluno(Integer.getInteger(""));
				session.setAttribute("LISTA", lista);
			} else if("editar".equals(cmd)){
				String id = request.getParameter("txtId");
				Emprestimo e = ((EmprestimoDao) eDao).pesquisarPorId(Long.parseLong(id));
				session.setAttribute("EMPRESTIMO_ATUAL", e);
				msg = "Detalhes do Emprestimo: " + id;
			} else if("salvar".equals(cmd)){
				Emprestimo e = new Emprestimo();
				String id = request.getParameter("txtId");
				e.setIdLivro(Integer.parseInt(request.getParameter("txtIdLivro")));
				e.setRaAluno(Integer.parseInt(request.getParameter("txtRaAluno")));
				String dataIni = request.getParameter("txtDataInicioEmp");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				try{
					Date dataEparse = (Date) sdf.parse(dataIni);
					e.setDataInicioEmp(dataEparse);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}
				String dataFim = request.getParameter("txtDataFimEmp");
				try {
					Date dataFparse = (Date) sdf.parse(dataFim);
					e.setDataFimEmp(dataFparse);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}
				((EmprestimoDao) eDao).salvar(Long.parseLong(id), e);
				List<Emprestimo> lista = ((EmprestimoDao) eDao).pesquisaPorAluno(Integer.getInteger(""));
				session.setAttribute("LISTA", lista);
				msg = "Emprestimo atualizado com sucesso";
 			}
		}catch (GenericDaoException | NumberFormatException e2){
			e2.printStackTrace();
			msg = "Erro ao acessar este emprestimo";
		}
		
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./emprestimo.jsp");
	}
}
