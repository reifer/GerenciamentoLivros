<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.br.Models.Usuario, com.br.Dao.UsuarioDaoImpl, com.br.Models.Livro, com.br.Dao.LivroDaoImpl, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuario</title>
<script>
	function busca() {
		$('#formUsuario').append(
				'<input type="hidden" name="cmd" value="busca"/>');
		$('#formUsuario').submit();
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
	%>
	<form id="formUsuario" class="formCadastro"
		action="./UsuarioController" method="post">
		<a href="./home.jsp" class="btn btn-primary"
			style="position: absolute; top: 10px; left: 10px;"> < </a>
		<div class="form-group">
			<h1>Cadastro de Usuario</h1>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Usuarios</label> <select
				onChange="busca();" name="ID" class="inputCadastro custom-select">
				<option value="<%=usuarioAtual.getId()%>"></option>
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
			<label class="labelCadastro">Nome</label> <input type="text"
				value="<%=usuarioAtual.getNome()%>" name="NOME"
				class="form-control inputCadastro">
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Tipo</label> <select name="TIPO"
				class="inputCadastro custom-select"
				value="<%=usuarioAtual.getTipo()%>">
				<%
					if (usuarioAtual.getTipo() == 1) {
				%>
				<option value="1">aluno</option>
				<option value="2">funcionario</option>
				<%
					} else if (usuarioAtual.getTipo() == 2) {
				%>
				<option value="2">funcionario</option>
				<option value="1">aluno</option>
				<%
					} else {
				%>
				<option value="0>"></option>
				<option value="1">aluno</option>
				<option value="2">funcionario</option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Email</label> <input type="email"
				value="<%=usuarioAtual.getEmail()%>" name="EMAIL"
				class="form-control inputCadastro">
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">Senha</label> <input type="text"
				value="<%=usuarioAtual.getSenha()%>" name="SENHA"
				class="form-control inputCadastro">
		</div>
		<div class="form-group formCadastroAlign">
			<label class="labelCadastro">telefone</label> <input type="text"
				value="<%=usuarioAtual.getTelefone()%>" name="TELEFONE"
				class="form-control inputCadastro">
		</div>
		<div class="btnPosition">
			<%
				if (usuarioAtual.getId() == 0) {
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