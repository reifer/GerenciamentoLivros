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
	<title>Login</title>
</head>
<body class="backgroundImage bodyLogin">

<form class="formLogin" action="./login" method="post"> 
	<h3 class="center">Login</h3>
	<div class="alignInputLogin">
		<div class="form-group formInput">
			<label class="textLogin">Email: </label>
			<input type="email" name="TXTUSER" class="form-control inputLogin inputSize">
		</div>
		<div class="form-group formInput">
			<label class="textLogin">Senha: </label>
			<input type="password" name="TXTPASS" class="form-control inputLogin inputSize">
		</div>
	</div>
	<div class="btnLogin">
		<button type="submit" class="btn btn-primary center">Entrar</button>
	</div>
</form>

</body>
</html>