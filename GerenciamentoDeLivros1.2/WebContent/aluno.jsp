<%@page import="com.br.Dao.EmprestimoDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.br.Models.Livro, com.br.Models.Usuario, com.br.Dao.LivroDaoImpl, com.br.Dao.UsuarioDaoImpl, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aluno</title>
</head>

<body class="backgroundImage">
	<%
		LivroDaoImpl lDao = new LivroDaoImpl();
		List<Livro> listlivro = lDao.getAll();
		
		
		int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
		EmprestimoDaoImpl eDao = new EmprestimoDaoImpl();
		List<Livro> listlivroEmprestado = eDao.pesquisaPorAluno(usuarioId);
	%>
	<form class="formCadastro" action="./emprestimoControllers" method="post">
	<a href="./" class="btn btn-primary"
			style="position: absolute; top: 10px; left: 10px;"> < </a>
		<div class="form-group">
			<h1>Aluno</h1>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Livros Com Você</label> <select name="IDLIVRO"
				class="inputCadastro custom-select">
				<option value="0"></option>
				<%
					if (listlivroEmprestado != null) {
				%>
				<%
					for (Livro l : listlivroEmprestado) {
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
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Livros Disponiveis</label> <select name="IDLIVRO"
				class="inputCadastro custom-select">
				<option value="0"></option>
				<%
					for (Livro l : listlivro) {
				%>
				<option value="<%=l.getId()%>"><%=l.getNome()%></option>
				<%
					}
				%>
			</select>
		</div>
	</form>
</body>

</html>