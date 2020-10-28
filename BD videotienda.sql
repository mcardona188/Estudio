drop database videotienda;
create database videotienda;
use videotienda;

#
# Structure for table "tiendas"
#
DROP TABLE IF EXISTS tiendas;
CREATE TABLE tiendas (
codigo varchar(4) NOT NULL,
Direccion varchar(60) NOT NULL,
PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tiendas"
#
INSERT INTO tiendas VALUES ('0001', "La Mota"),('0002',"Estadio");

select * from tiendas;
#
# Structure for table "catalogo"
#
DROP TABLE IF EXISTS catalogo;
CREATE TABLE catalogo (
  ID_pelicula int(6) NOT NULL,
  Nombre varchar(60) NOT NULL,
  Genero varchar(30) NOT NULL,
  Año int(4) NOT NULL,
  Clasificacion char(7) NOT NULL,
  Protagonistas varchar(30) NOT NULL,
  Director varchar(30) NOT NULL,
  Estado char(13) NOT NULL,
	tienda varchar(4) NOT NULL,
  PRIMARY KEY (ID_pelicula),
	CONSTRAINT catalogo_ibfk_2 FOREIGN KEY (tienda) REFERENCES tiendas (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "catalogo"
#
INSERT INTO catalogo VALUES (1,'Rey León','Infantil, Drama',2019,'Todos','Chiwetel Ejiofor, John Oliver','Jon Favreau','No disponible','0001'),
(2,'Titanic','Drama',1997,'+6años','Leonardo DiCaprio, Kate Winsle','James Cameron','Disponible','0002'),
(3,'Avengers: Los Vengadores','Acción, ficción',2012,'+4años','Robert Downey Jr., Chris Evans','Joss Whedon','Disponible','0001');

#
# Structure for table "usuarios"
#
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

-- ALTER TABLE usuarios MODIFY Tel_fijo varchar(10) NOT NULL;

#
# Data for table "empleados"
#
INSERT INTO usuarios VALUES (85936541,'Jorge Luis','Pérez Coa',2984055,'3003197250','CR 27 # 36D SUR-280(802)','Sabaneta',1,9917),
(96541238,'Luis Carlos','Ríos Pérez',2596209,'3004201250','CL 54 # 56-70','Itagüí',2,4358),
(99332565,'Mary Luz','Mesa Suárez',5683591,'3116585987','CL 31 # 43-12','Medellín',2,1234);

#
# Structure for table "metodos_pago"
#
DROP TABLE IF EXISTS metodos_pago;
CREATE TABLE metodos_pago (
	id int(10) NOT NULL,
	nombre varchar (10),
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "metodos_pago"
#
INSERT INTO metodos_pago VALUES (1,"Efectivo"),(2,"Crédito"),(3,"Débito"),(4,"PSE");

#
# Structure for table "rentas"
#
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


#
# Data for table "rentas"
#
INSERT INTO rentas VALUES (1,'2020-10-11','2020-10-28',85936541,1,4),(2,'2020-10-15','2020-10-30',85936541,3,3),
(3,'2020-11-02','2020-11-15',96541238,2,1),(4,'2020-11-03','2020-11-14',99332565,3,2);
select * from rentas;
select * from usuarios where Documento='85936541' and Contrasena=9917;
