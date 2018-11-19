<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/bootstrap.min.css" />
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>

<body class="bodyHome backgroundImage">
	<div class="formHome">
		<a href="./" class="btn btn-primary"
			style="position: absolute; top: 10px; left: 10px;"> < </a>
		<div class="titleHome">
			<h1>Gerenciamento de Livros</h1>
		</div>
		<div class="container containerHome">
			<div class="buttonHomePosition">
				<a href="./cadastroDeLivros.jsp" class="btn btn-primary buttonHome">Cadastro
					de Livros</a>
			</div>
			<div class="buttonHomePosition">
				<a href="./cadastroDeUsuario.jsp" class="btn btn-primary buttonHome">Cadastro
					de Usuarios</a>
			</div>
			<div class="buttonHomePosition">
				<a href="./emprestimo.jsp" class="btn btn-primary buttonHome">Emprestimo</a>
			</div>
			<div class="buttonHomePosition">
				<a href="./devolucao.jsp" class="btn btn-primary buttonHome">Devolução</a>
			</div>
		</div>
	</div>
</body>

</html>