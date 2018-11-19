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
    <title>Cadastro de Aluno</title>
</head>

<body class="backgroundImage">
    <form class="formCadastro">
        <div class="form-group">
            <h1>Cadastro de Usuario</h1>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Usuarios</label>
            <select name="" id="" class="inputCadastro custom-select">
                <option value="0"></option>
                <option value="1">Jãozinho da silva</option>
                <option value="2">Angela de las flores</option>
                <option value="3">Não consegue né moises</option>
            </select>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Nome</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Tipo</label>
            <select name="" id="" class="inputCadastro custom-select">
                    <option value="0"></option>
                    <option value="1">aluno</option>
                    <option value="2">funcionario</option>
                </select>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Email</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">telefone</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="btnPosition">
            <button type="submit" class="btn btn-primary">Salvar</button>
            <button type="submit" class="btn btn-danger">Deletar</button>
            <button type="submit" class="btn btn-danger">Alterar</button>
        </div>
    </form>
</body>

</html>