<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <title>Login</title>
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