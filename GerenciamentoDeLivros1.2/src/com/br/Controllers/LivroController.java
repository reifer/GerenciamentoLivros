package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.GenericDaoException;
import com.br.Dao.LivroDaoImpl;
import com.br.Models.Livro;

import javax.servlet.ServletException;

@WebServlet(urlPatterns = "/LivroControllers")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LivroController() {
		super();
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();

		try {
			LivroDaoImpl lDao = new LivroDaoImpl();
			if ("adiciona".equals(cmd)) {
				Livro l = new Livro();
				l.setId(0);
				l.setNome(request.getParameter("NOME"));
				l.setGenero(request.getParameter("GENERO"));
				l.setAutor(request.getParameter("AUTOR"));
				l.setEditora(request.getParameter("EDITORA"));
				lDao.adiciona(l);
				List<Livro> lista = lDao.getAll();
				session.setAttribute("LISTA", lista);
				msg = "Livro adicionado com sucesso!";
			} else if ("remover".equals(cmd)) {
				String id = request.getParameter("ID");
				lDao.remover((int) Long.parseLong(id));
				List<Livro> lista = lDao.getAll();
				session.setAttribute("LISTA", lista);
				session.setAttribute("LIVRO_ATUAL", null);
			} else if ("busca".equals(cmd)) {
				String id = request.getParameter("ID");
				Livro l = lDao.pesquisarPorId(Integer.parseInt(id));
				session.setAttribute("LIVRO_ATUAL", l);
			} else if ("alterar".equals(cmd)) {
				Livro l = new Livro();
				l.setId(Integer.parseInt(request.getParameter("ID")));
				l.setNome(request.getParameter("NOME"));
				l.setGenero(request.getParameter("GENERO"));
				l.setAutor(request.getParameter("AUTOR"));
				l.setEditora(request.getParameter("EDITORA")); //
				l.setSatus(true);
				lDao.editar(l);
				List<Livro> lista = lDao.getAll();
				session.setAttribute("LISTA", lista);
			}

		} catch (GenericDaoException | NumberFormatException e) {
			e.printStackTrace();
			msg = "Erro ao acessar o Livro.";
		}

		response.sendRedirect("./cadastroDeLivros.jsp");
	}

}