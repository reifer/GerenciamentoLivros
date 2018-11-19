package com.br.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.Dao.GenericDaoException;
import com.br.Dao.UsuarioDao;
import com.br.Dao.UsuarioDaoImpl;
import com.br.Models.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		HttpSession session = request.getSession();
		try {
			UsuarioDao uDao = new UsuarioDaoImpl();
			if ("adiciona".equals(cmd)) {
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(request.getParameter("ID")));
				u.setNome(request.getParameter("NOME"));
				u.setEmail(request.getParameter("EMAIL"));
				u.setSenha(request.getParameter("SENHA"));
				u.setTipo(Integer.parseInt(request.getParameter("TIPO")));
				u.setTelefone(request.getParameter("TELEFONE"));
				uDao.adiciona(u);
			} else if ("remover".equals(cmd)) {
				int id = Integer.parseInt(request.getParameter("ID"));
				uDao.remover(id);
				session.setAttribute("USUARIO_ATUAL", null);
			} else if ("busca".equals(cmd)) {
				String id = request.getParameter("ID");
				Usuario u = uDao.pesquisarPorId(Integer.parseInt(id));
				session.setAttribute("USUARIO_ATUAL", u);
			} else if ("alterar".equals(cmd)) {
				Usuario u = new Usuario();
				u.setId(Integer.parseInt(request.getParameter("ID")));
				u.setNome(request.getParameter("NOME"));
				u.setEmail(request.getParameter("EMAIL"));
				u.setSenha(request.getParameter("SENHA"));
				u.setTelefone(request.getParameter("TELEFONE"));
				u.setTipo(Integer.parseInt(request.getParameter("TIPO")));
				session.setAttribute("USUARIO_ATUAL", null);
				uDao.editar(u);
			}
		} catch (GenericDaoException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./cadastroDeUsuario.jsp");
	}
}