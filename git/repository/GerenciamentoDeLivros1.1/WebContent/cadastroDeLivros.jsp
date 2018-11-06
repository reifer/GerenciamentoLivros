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
            <h1>Cadastro de Livros</h1>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Livros</label>
            <select name="" id="" class="inputCadastro custom-select">
                    <option value="0"></option>
                    <option value="1">As cronicas de narnia</option>
                    <option value="2">Harry potter</option>
                    <option value="3">percy jackson</option>
            </select>
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Nome</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Autor</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Gênero</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="form-group formCadastroAlign">
            <label class="labelCadastro">Editora</label>
            <input type="text" class="form-control inputCadastro">
        </div>
        <div class="btnPosition">
            <button type="submit" class="btn btn-primary">Salvar</button>
            <button type="submit" class="btn btn-danger">Deletar</button>
        </div>
    </form>
</body>

</html>