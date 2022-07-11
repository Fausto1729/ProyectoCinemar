Drop database if exists cinemar;
CREATE DATABASE cinemar;
USE cinemar;

create table persona(
id int unsigned auto_increment primary key,
nombre varchar(25) not null,
apellido varchar(50) not null,
nacimiento varchar(15),
documento varchar(15) not null,
telefono varchar(20) not null,
correo varchar(50) not null unique,
contraseña varchar(20) not null,
roll enum('administrador','cliente') not null
);

insert into persona(nombre,apellido,nacimiento,documento,telefono,correo,contraseña,roll)
values
('admin','istrador','01/01/1001','11.111.111','1111111111','admin@gmail.com','admin','administrador'),
('clien','te','02/02/2002','22.222.222','2222222222','cliente@gmail.com','cliente','cliente');

select * from persona;

create table pelicula(
id int unsigned auto_increment primary key,
nombre varchar(50) unique,
genero varchar(30),
duracion varchar(20),
idioma varchar(30)
);

insert into pelicula(nombre,genero,duracion,idioma)
values
('Rapidos y Furiosos','Accion','120 min','castellano'),
('El Señor de los Anillos','Ciencia Ficcion','120 min','subtitulado'),
('Batman: El caballero de la noche','Accion','180 min','subtitulado'),
('El Conjunro 3','Horror','120 min','castellano'),
('Son Como Niños','Comedia','150 min','subtitulado');

select * from pelicula;

create table sala(
id int auto_increment not null,
nombre varchar(10) unique,
primary key (id)
);

insert into sala(nombre)
values
('A');

select * from sala;

create table funcion(
id int unsigned auto_increment primary key,
fecha varchar(20),
hora varchar(20),
pelicula varchar(50),
sala varchar(10),
foreign key (pelicula) references pelicula(nombre),
foreign key (sala) references sala(nombre)
);

insert into funcion(fecha, hora, pelicula, sala)
values
('Lunes 20/05/2022','18:00','Rapidos y Furiosos','A'),
('Martes 21/05/2022','21:00','El Señor de los Anillos','A'),
('Miercoles 22/05/2022','24:00','Batman: El caballero de la noche','A'),
('Lunes 20/05/2022','18:00','El Conjunro 3','A'),
('Martes 21/05/2022','21:00','Son Como Niños','A'),
('Miercoles 22/05/2022','24:00','Rapidos y Furiosos','A'),
('Lunes 20/05/2022','18:00','El Señor de los Anillos','A'),
('Martes 21/05/2022','21:00','Batman: El caballero de la noche','A'),
('Miercoles 22/05/2022','24:00','El Conjunro 3','A'),
('Lunes 20/05/2022','18:00','Son Como Niños','A'),
('Martes 21/05/2022','21:00','Rapidos y Furiosos','A'),
('Miercoles 22/05/2022','24:00','El Señor de los Anillos','A'),
('Lunes 20/05/2022','18:00','Batman: El caballero de la noche','A'),
('Martes 21/05/2022','21:00','El Conjunro 3','A'),
('Miercoles 22/05/2022','24:00','Son Como Niños','A');

select * from funcion;

create table butaca(
id int auto_increment primary key,
butaca varchar(2),
estado boolean,
sala varchar(1),
funcion int unsigned,
foreign key(sala) references sala(nombre),
foreign key(funcion) references funcion(id)
);

insert into 
butaca(butaca, estado, sala, funcion)
values
('a1',true,'A', 1),('b1',true,'A', 1),('c1',true,'A', 1),('d1',true,'A', 1),('e1',true,'A', 1),
('a2',true,'A', 1),('b2',true,'A', 1),('c2',true,'A', 1),('d2',true,'A', 1),('e2',true,'A', 1),
('a3',true,'A', 1),('b3',true,'A', 1),('c3',true,'A', 1),('d3',true,'A', 1),('e3',true,'A', 1),
('a4',true,'A', 1),('b4',true,'A', 1),('c4',true,'A', 1),('d4',true,'A', 1),('e4',true,'A', 1),
('a5',true,'A', 1),('b5',true,'A', 1),('c5',true,'A', 1),('d5',true,'A', 1),('e5',true,'A', 1);

select * from butaca;

create table reserva(
id int auto_increment primary key,
butacas int,
titular varchar(50),
foreign key(titular) references persona(correo)
);
select * from reserva;