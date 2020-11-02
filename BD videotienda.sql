# Creación BD
drop database videotienda;
create database videotienda;
use videotienda;

#Tabla "tiendas"
DROP TABLE IF EXISTS tiendas;
CREATE TABLE tiendas (
codigo varchar(4) NOT NULL,
Direccion varchar(60) NOT NULL,
PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO tiendas VALUES  ('0001','La Mota'),('0002','Estadio'),
												  	('0003','Envigado');

#Tabla "catalogo"
DROP TABLE IF EXISTS catalogo;
CREATE TABLE catalogo (
  ID_pelicula int(6) NOT NULL,
  Nombre varchar(60) NOT NULL,
  Genero varchar(30) NOT NULL,
  anio int(4) NOT NULL,
  Clasificacion char(7) NOT NULL,
  Protagonistas varchar(30) NOT NULL,
  Director varchar(30) NOT NULL,
  Estado char(13) NOT NULL,
	tienda varchar(4) NOT NULL,
  PRIMARY KEY (ID_pelicula),
	CONSTRAINT catalogo_ibfk_2 FOREIGN KEY (tienda) REFERENCES tiendas (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO catalogo VALUES 
(1,'Rey León','Infantil, Drama',2019,'Todos','Chiwetel Ejiofor, John Oliver','Jon Favreau','No disponible','0001'),
(2,'Titanic','Drama',1997,'+6años','Leonardo DiCaprio, Kate Winsle','James Cameron','Disponible','0002'),
(3,'Avengers: Los Vengadores','Acción, ficción',2012,'+4años','Robert Downey Jr., Chris Evans','Joss Whedon','Disponible','0001'),
(4,'Yo Daniel: I Daniel Blake','Drama, amistad',2016,'+13años','Dave Jons., Hayley Squires','Ken Loachn','Disponible','0002'),
(5,'Rápido y Furioso','Acción, saga',2001,'+11años','Vin Diesel, Paul Walker','Rob Cohen','No disponible','0002'),
(6,'Charlie y la Fábrica de chocolates','Infantil, teatro',2012,'+3años','Johnny Depp, Freddie Highmore','Tim Burton','Disponible','0002');

#Tabla "usuarios"
DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
  Documento int(11) NOT NULL,
  Nombre varchar(30) NOT NULL,
  Apellidos varchar(30) NOT NULL,
  Tel_fijo varchar(10) NOT NULL,
  Tel_celular varchar(10) NOT NULL,
  Direccion varchar(60) NOT NULL,
  Ciudad varchar(30) NOT NULL,
  Nivel_Usu int(2) NOT NULL,
  Contrasena int(4) NOT NULL,
  PRIMARY KEY (Documento)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO usuarios VALUES 
(32439724,'Elena','Sánchez Vargas','2556203','3012459718','CR 51 # 46-13','Guarne',2,9724),
(41289742,'Luisa.','Muñoz.','4643518','3153258971','Cr 234 # 34-52','Medellín',2,4321),
(45687323,'Nathalie','Tamayo','5693525','3003259825','Cr 43 # 54-16','Envigado',2,1234),
(64564130,'Albert D.','Berrío B.','3803552','3103259874','Cr 54 # 65-7','Medellín',2,4060),
(71640640,'Miguel Ángel','Cardona Gallego','3801864','3103197291','CL 54 # 56-70','Medellín',1,640),
(85936541,'Jorge Luis','Pérez Coa','2984055','3003197250','CR 27 # 36D SUR-280(802)','Sabaneta',1,9917),
(96541238,'Luis Carlos','Ríos Pérez','2596209','3004201250','CL 54 # 56-70','Itagüí',2,4358),
(99332565,'Mary Luz','Mesa Suárez','5683591','3116585987','CL 31 # 43-12','Medellín',2,1234);

#Tabla "metodos_pago"
DROP TABLE IF EXISTS metodos_pago;
CREATE TABLE metodos_pago (
	id int(10) NOT NULL,
	nombre varchar (10),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO metodos_pago VALUES (1,"Efectivo"),(2,"Crédito"),
																(3,"Débito"),(4,"PSE");

#Tabla "rentas"
DROP TABLE IF EXISTS rentas;
CREATE TABLE rentas (
  ID_Tiket int(10) NOT NULL,
  Fecha_prestamo date NOT NULL,
  Fecha_retorno date NOT NULL,
  Cliente int(11) NOT NULL,
  Pelicula int(6) NOT NULL,
	metodo_pago int(10) NOT NULL,
 PRIMARY KEY (ID_Tiket),
  KEY Cliente (Cliente),
  KEY Pelicula (Pelicula),
  CONSTRAINT rentas_ibfk_1 FOREIGN KEY (Cliente) REFERENCES usuarios (Documento),
  CONSTRAINT rentas_ibfk_2 FOREIGN KEY (Pelicula) REFERENCES catalogo (ID_pelicula),
	CONSTRAINT rentas_ibfk_3 FOREIGN KEY (metodo_pago) REFERENCES metodos_pago (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO rentas VALUES 
(1,'2020-10-11','2020-10-28',85936541,1,4),
(2,'2020-10-15','2020-10-30',85936541,3,3),
(3,'2020-11-02','2020-11-15',96541238,2,1),
(4,'2020-11-03','2020-11-14',99332565,3,2),
(5,'2020-10-03','2020-10-05',99332565,2,1), 
(6,'2020-10-13','2020-10-16',99332565,1,4);


#Consultas (Query)

select * from tiendas;
select * from tiendas where codigo = '0001';

select * from catalogo where ID_pelicula = 1;
select * from catalogo where Estado = 'Disponible' Order by Nombre Asc;

select * from usuarios where Documento = '32439724' and Contrasena=9917;
select * from usuarios where Documento = '71640640';
select * from usuarios where Nivel_Usu = 2 Order by Documento Asc;

select * from metodos_pago where id = 1;

select * from rentas;
select * from rentas where ID_Tiket = 1;

select * from rentas where Cliente = 99332565; 
