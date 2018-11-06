package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.AlunoDao;
import com.br.Dao.AlunoDaoImpl;
import com.br.Dao.GenericDaoException;
import com.br.Models.Aluno;

@WebServlet("/AlunoControllers")
public class AlunoControllers extends HttpServlet {
	
	private static final long serialVersionUID = 1l;
	
	public AlunoControllers(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter()
				.append("Acesso realizado pelo fomrulário <a href=\"./aluno.jsp\">aluno</a>")
				.append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cmd = request.getParameter("cmd");
		String msg = null;
		AlunoDao aDao = new AlunoDaoImpl();
		HttpSession session = request.getSession();
		
		if("adicionar".equals(cmd)){
			Aluno aluno = new Aluno();
			
			aluno.setId(Integer.parseInt((request.getParameter("alunoId"))));
			aluno.setNome(request.getParameter("alunoNome"));
			aluno.setEmail(request.getParameter("alunoEmail"));
			aluno.setTipo(request.getParameter("alunoTipo"));
			aluno.setTelefone(request.getParameter("alunoTelefone"));
			aluno.setRa(Integer.parseInt((request.getParameter("alunoRa"))));
			aluno.setCurso(request.getParameter("alunoCurso"));
			
			try {
				aDao.adiciona(aluno);
				List<Aluno> lista = aDao.pesquisarRA(Integer.parseInt(request.getParameter("alunoRa")));
				session.setAttribute("ALUNOS", lista);
				msg = "Aluno adicionado com Sucesso!";
			} catch (GenericDaoException e) {
				e.printStackTrace();
			}
		} else if("pesuisar".equals(cmd)){
			try {
				List<Aluno> lista = aDao.pesquisarRA(Integer.parseInt(request.getParameter("alunoRa")));
				session.setAttribute("ALUNOS", lista);
				msg = "Foram encontrados" +lista.size() +"Alunos";
			}  catch (GenericDaoException e) {
				e.printStackTrace();
			}
			
		} else if("remover".equals(cmd)){
			String Ra = request.getParameter("alunoRa");
			try {
				aDao.remover(Integer.parseInt(Ra));
				List<Aluno> lista = aDao.pesquisarRA(Integer.parseInt(Ra));
				session.setAttribute("ALUNOS", lista);
				msg = "Aluno com RA: " +Ra+ "foi removido";
			}  catch (NumberFormatException | GenericDaoException e ) {
				msg = "Erro ao remover aluno com Ra: "+Ra;
				e.printStackTrace();
			}
			
		}
		
		else if("atualizar".equals(cmd)){
			String Ra = request.getParameter("alunoRa");
			try {
				Aluno aluno = (Aluno) aDao.pesquisarRA(Integer.parseInt(Ra));
				session.setAttribute("ALUNOS", aluno);
				msg = "Aluno com RA: " +Ra+ "foi carregado";
			} catch (NumberFormatException | GenericDaoException e) {
				msg = "Erro ao carregar aluno com RA: "+Ra;
				e.printStackTrace();
			} 
		}
		
		else if("salvar".equals(cmd)){
			String Ra = request.getParameter("alunoRa");
						
			try {
				
				Aluno aluno = new Aluno();
				aluno.setNome(request.getParameter("alunoNome"));
				aluno.setEmail(request.getParameter("alunoEmail"));
				aluno.setRa(Integer.parseInt(request.getParameter("alunoRa")));
				aluno.setTelefone(request.getParameter("alunoTelefone"));
				aluno.setCurso(request.getParameter("alunoCurso"));
				aluno.setTipo(request.getParameter("alunoTipo"));

				aDao.alterar(Integer.parseInt(Ra),aluno);
				msg = "Aluno com RA: " +Ra+ "Foi atualizao no banco";
				List<Aluno> lista = aDao.pesquisarRA(Integer.parseInt(Ra));
				session.setAttribute("ALUNOS", lista);
				
			} catch (NumberFormatException | GenericDaoException e) {
				msg = "Erro ao atualizar aluno com RA: "+Ra;
				e.printStackTrace();
			}
			
		}
		
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./aluno.jsp");
	}
	

}
