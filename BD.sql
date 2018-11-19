create database gerenciamentodelivros;
use gerenciamentodelivros
create table livro(
	idlivro int AUTO_INCREMENT,
	nome varchar(50),
	genero varchar(50),
	autor varchar(50),
	editora varchar(50),
	status boolean,
	primary key (idLivro)
);

create table Usuario(
	id int AUTO_INCREMENT,
	nome varchar(50),
	email varchar(50),
	tipo int,
	telefone varchar(50),
	primary key(id)
);

create table emprestimo(
	id int AUTO_INCREMENT,
	idLivro int,
	IdUsuario int,
	datainicio varchar(11),
	datafim varchar(11),
	primary key(id)
);