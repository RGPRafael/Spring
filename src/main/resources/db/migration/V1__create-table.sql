/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  rafael
 * Created: 21 de nov. de 2023
 */



create table Missoes(

    id bigint not null auto_increment,
    descrição varchar(100) not null,
    recompensa int not null,
    primary key(id)

);


create table Hunters(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    descrição varchar(100) not null,
    estrelas int not null,
    provasfeitas  int not null,
    temlicenca boolean not null default false,
    nem varchar(9) not null,
    cadastro DATETIME not null,
    pais varchar(100),
    continente varchar(100),
    localizaçãoconhecida  boolean not null default false,
    primary key(id)

);

