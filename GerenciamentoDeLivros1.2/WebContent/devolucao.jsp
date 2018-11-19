<%@page import="com.br.Models.Livro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.br.Models.Usuario, com.br.Models.Livro, com.br.Dao.UsuarioDaoImpl, com.br.Dao.LivroDaoImpl, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devolução</title>
<script>
	function busca() {
		$('#formDevolucao').append(
				'<input type="hidden" name="cmd" value="busca"/>');
		$('#formDevolucao').submit();
	}
</script>
</head>

<body class="backgroundImage">
	<%
		UsuarioDaoImpl uDao = new UsuarioDaoImpl();
		List<Usuario> listUsuario = uDao.getAllUser();
		Usuario usuarioAtual = (Usuario) session.getAttribute("USUARIO_ATUAL");
		if (usuarioAtual == null) {
			usuarioAtual = new Usuario();
			usuarioAtual.setId(0);
		} else {
			session.setAttribute("USUARIO_ATUAL", null);
		}

		List<Livro> listLivro = (List) session.getAttribute("LIVROS_USUARIO");
	%>
	<form id="formDevolucao" class="formCadastro"
		action="./emprestimoControllers" method="post">
		<a href="./home.jsp" class="btn btn-primary"
			style="position: absolute; top: 10px; left: 10px;"> < </a>
		<div class="form-group">
			<h1>Devolução</h1>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Alunos</label> <select name="IDUSUARIO"
				onChange="busca();" class="inputCadastro custom-select">
				<option value="<%=usuarioAtual.getId()%>"><%=usuarioAtual.getNome()%></option>
				<%
					for (Usuario u : listUsuario) {
				%>
				<option value="<%=u.getId()%>"><%=u.getNome()%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Livro</label> <select name="IDLIVRO"
				class="inputCadastro custom-select">
				<option value="0"></option>
				<%
					if (listLivro != null) {
				%>
				<%
					for (Livro l : listLivro) {
				%>
				<option value="<%=l.getId()%>"><%=l.getNome()%></option>
				<%
					}
				%>
				<%
					}
				%>
			</select>
		</div>
		<div class="btnPosition">
			<button type="submit" name="cmd" value="devolver"
				class="btn btn-primary">Devolver</button>
		</div>
	</form>
</body>

</html>