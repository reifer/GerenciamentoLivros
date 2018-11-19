<%@page import="com.br.Dao.LivroDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.br.Models.Livro, com.br.Dao.LivroDaoImpl, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Livros</title>
<script>
function busca() {
	$('#formLivro').append('<input type="hidden" name="cmd" value="busca"/>');
	$('#formLivro').submit();
}
</script>
</head>

<body class="backgroundImage">
	<%
		LivroDaoImpl lDao = new LivroDaoImpl();
		List<Livro> listlivro = lDao.getAll();
		Livro livroAtual = (Livro)session.getAttribute("LIVRO_ATUAL");
		if (livroAtual == null){
			livroAtual = new Livro();
			livroAtual.setId(0);
		} else {
			session.setAttribute("LIVRO_ATUAL", null);
		}
	%>
	<form id="formLivro" class="formCadastro" action="./LivroControllers"
		method="post">
		<a href="./home.jsp" class="btn btn-primary"
			style="position: absolute; top: 10px; left: 10px;"> < </a>
		<div class="form-group">
			<h1>Cadastro de Livros</h1>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Livros</label> 
			<select name="ID" onChange="busca();" class="inputCadastro custom-select">
				<option value="<%=livroAtual.getId()%>"></option>
				<%
					for (Livro l : listlivro) {
				%>
				<option value="<%=l.getId()%>"><%=l.getNome()%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Nome</label> <input type="text"
				value="<%=livroAtual.getNome()%>" name="NOME"
				class="form-control inputCadastro">
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Autor</label> <input type="text"
				value="<%=livroAtual.getAutor()%>" name="AUTOR"
				class="form-control inputCadastro">
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Gênero</label> <input type="text"
				value="<%=livroAtual.getGenero()%>" name="GENERO"
				class="form-control inputCadastro">
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Editora</label> <input type="text"
				value="<%=livroAtual.getEditora()%>" name="EDITORA"
				class="form-control inputCadastro">
		</div>
		<div class="btnPosition">
			<%
				if (livroAtual.getId() == 0) {
			%>
			<button type="submit" name="cmd" value="adiciona"
				class="btn btn-primary">Adicionar</button>
			<%
				} else {
			%>
			<button type="submit" name="cmd" value="alterar"
				class="btn btn-primary">Alterar</button>
			<%
				}
			%>
			<button type="submit" name="cmd" value="remover"
				class="btn btn-danger">Deletar</button>
		</div>
	</form>
</body>

</html>