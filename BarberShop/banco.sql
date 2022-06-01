create database if not exists barbershop default character set utf8 default collate utf8_general_ci;
use barbershop;
create table if not exists usuario (
	id int not null auto_increment primary key,
	usuario varchar (30) unique not null,
	senha varchar (40) not null
) default charset = utf8mb4;
insert into usuario(usuario, senha) values ('admin', 'admin');
select * from usuario;