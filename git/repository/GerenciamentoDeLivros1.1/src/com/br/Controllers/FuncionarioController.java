package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.FuncionarioDao;
import com.br.Dao.FuncionarioDaoImpl;
import com.br.Dao.GenericDaoException;
import com.br.Models.Funcionario;
import com.br.Models.Livro;

@WebServlet
public class FuncionarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public FuncionarioController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Para acessar login utilize a pagina de <a href=\"./login.jsp\">login</a>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		
		try {
			FuncionarioDao fDao = new FuncionarioDaoImpl();
			if("adiciona".equals(cmd)){
				Funcionario f = new Funcionario();
				f.setNome(request.getParameter("nome"));
				f.setEmail(request.getParameter("email"));
				f.setTelefone(request.getParameter("telefone"));
				f.setCpf(request.getParameter("cpf"));
				f.setMatricula(request.getParameter("matricula"));
				//f.setTipo(request.getParameter("tipo"));
				//f.setId(request.getParameter("id"));
				fDao.adiciona(f);
				List<Funcionario> lista = fDao.adiciona("");
				session.setAttribute("LISTA", lista);
				msg = "Funcionario adicionaco com sucesso";
			}else if("pesquisar".equals(cmd)){
				List<Funcionario> lista = fDao.pesquisarPorMatricula(request.getParameter("txtMatricula"));
				session.setAttribute("LISTA", lista);
				msg = "Funcionario encontrado " + lista.size() + " funcionarios";
			}else if("remover".equals(cmd)){
				String matricula = request.getParameter("txtMatricula");
				fDao.remover(matricula);
				msg = "Funcionario com Matricula " + matricula + " foi removido com sucesso!";
			}else if("editar".equals(cmd)){
				String matricula = request.getParameter("txtMatricula");
				Funcionario f = (Funcionario) fDao.pesquisarPorMatricula(matricula);
				session.setAttribute("FUNCIONARIO_ATUAL", f);
				msg = "Dados do Funcionario foram alterados com sucesso!";
			}else if("salvar".equals(cmd)){
				Funcionario f = new Funcionario();
				String matricula = request.getParameter("txtMatricula");
				f.setNome(request.getParameter("nome"));
				f.setEmail(request.getParameter("email"));
				f.setTelefone(request.getParameter("telefone"));
				f.setCpf(request.getParameter("cpf"));
				f.setMatricula(matricula);
				//f.setTipo(request.getParameter("tipo"));
				//f.setId(request.getParameter("id"));
				fDao.salvar(matricula, f);
				List<Funcionario> lista = fDao.pesquisarPorMatricula("");
				session.setAttribute("LISTA", lista);
				msg = "Funcionario salvo com sucesso!";
			}
		} catch (GenericDaoException | NumberFormatException e) {
			e.printStackTrace();
			msg = "Erro ao acessar o Funcionario.";			
		}
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./funcionario.jsp");
	}

}
