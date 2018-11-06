package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.GenericDaoException;
import com.br.Dao.LivroDao;
import com.br.Dao.LivroDaoImpl;
import com.br.Models.Livro;

import javax.servlet.ServletException;

@WebServlet("/LivroControllers")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroController() {
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
			LivroDao lDao = new LivroDaoImpl();
			if("adiciona".equals(cmd)){
				Livro l = new Livro();
				l.setNome(request.getParameter("nome"));
				l.setGenero(request.getParameter("genero"));
				l.setAutor(request.getParameter("autor"));
				l.setEditora(request.getParameter("editora"));
				lDao.adiciona(l);
				List<Livro> lista = lDao.pesquisarPorAutor("");
				session.setAttribute("LISTA", lista);
				msg = "Livro adicionado com sucesso!";
			}else if ("pesquisar".equals(cmd)){
				List<Livro> lista = lDao.pesquisarPorAutor(request.getParameter("txtAutor"));
				session.setAttribute("LISTA", lista);
				msg = "Foram encontrado " + lista.size() + " livros";
			}else if("remover".equals(cmd)){
				String id = request.getParameter("txtId");
				lDao.remover(Long.parseLong(id));
				msg = "Livro com ID " + id + " foi removido com sucesso!";
			}else if("editar".equals(cmd)){
				String id = request.getParameter("txtId");
				Livro l = lDao.pesquisarPorId(Long.parseLong(id));
				session.setAttribute("Livro_ATUAL", l);
				msg = "Detalhes do Livro foram editados!";
			}else if("salvar".equals(cmd)){
				Livro l = new Livro();
				String id = request.getParameter("txtId");
				l.setNome(request.getParameter("nome"));
				l.setGenero(request.getParameter("genero"));
				l.setAutor(request.getParameter("autor"));
				l.setEditora(request.getParameter("editora"));
				//l.setSatus(request.getParameter("status"));
				lDao.salvar(Long.parseLong(id), l);
				List<Livro> lista = lDao.pesquisarPorAutor("");
				session.setAttribute("LISTA", lista);
				msg = "Livro atualizado com sucesso!";
			}
		} catch (GenericDaoException | NumberFormatException e) {
			e.printStackTrace();
			msg = "Erro ao acessar o Livro.";
		}
		
		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./login.jsp");
	}

}