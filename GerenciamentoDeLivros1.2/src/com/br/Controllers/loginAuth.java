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

@WebServlet(urlPatterns = "/login")
public class loginAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		HttpSession session = request.getSession();

		if (user.isEmpty() || pass.isEmpty()) {
			response.sendRedirect("./");
		} else {
			try {
				UsuarioDao uDao = new UsuarioDaoImpl();
				Usuario usuario = uDao.login(user, pass);
				if (usuario.getTipo() == 2) {
					response.sendRedirect("./home.jsp");
				} else if (usuario.getTipo() == 1){
					response.sendRedirect("./aluno.jsp?usuarioId=" + usuario.getId());
				} else {
					response.sendRedirect("./");
				}
			} catch (GenericDaoException e) {
				e.printStackTrace();
			}

		}
	}
}
