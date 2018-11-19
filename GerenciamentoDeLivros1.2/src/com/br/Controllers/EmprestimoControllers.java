package com.br.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.br.Dao.EmprestimoDaoImpl;
import com.br.Dao.GenericDaoException;
import com.br.Dao.UsuarioDao;
import com.br.Dao.UsuarioDaoImpl;
import com.br.Models.Emprestimo;
import com.br.Models.Livro;
import com.br.Models.Usuario;

@WebServlet(urlPatterns = "/emprestimoControllers")
public class EmprestimoControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmprestimoControllers() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		try {
			EmprestimoDaoImpl eDao = new EmprestimoDaoImpl();
			if ("emprestar".equals(cmd)) {
				Emprestimo e = new Emprestimo();
				e.setIdLivro(Integer.parseInt(request.getParameter("IDLIVRO")));
				e.setIdUsuario(Integer.parseInt(request.getParameter("IDUSUARIO")));
				eDao.adiciona(e);
			} else if ("busca".equals(cmd)) {
				UsuarioDao uDao = new UsuarioDaoImpl();
				Usuario u = uDao.pesquisarPorId(Integer.parseInt(request.getParameter("IDUSUARIO")));
				session.setAttribute("USUARIO_ATUAL", u);

				List<Livro> listLivros = eDao.pesquisaPorAluno(Integer.parseInt(request.getParameter("IDUSUARIO")));
				session.setAttribute("LIVROS_USUARIO", listLivros);
			} else if ("devolver".equals(cmd)) {
				Emprestimo e = new Emprestimo();
				e.setIdUsuario(Integer.parseInt(request.getParameter("IDUSUARIO")));
				e.setIdLivro(Integer.parseInt(request.getParameter("IDLIVRO")));
				eDao.devolver(e);
			}
		} catch (GenericDaoException e) {
			e.printStackTrace();
		}
		
		System.out.println(cmd);
		if (cmd.equals("emprestar")) {
			response.sendRedirect("./emprestimo.jsp");
		} else {
			response.sendRedirect("./devolucao.jsp");
		}

	}
}
