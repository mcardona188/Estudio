# Host: localhost  (Version 5.5.24-log)
# Date: 2020-10-26 18:15:10
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "catalogo"
#

DROP TABLE IF EXISTS `catalogo`;
CREATE TABLE `catalogo` (
  `ID_pelicula` int(6) NOT NULL,
  `Nombre` varchar(60) NOT NULL,
  `Genero` varchar(30) NOT NULL,
  `Año` int(4) NOT NULL,
  `Clasificacion` char(7) NOT NULL,
  `Protagonistas` varchar(30) NOT NULL,
  `Director` varchar(30) NOT NULL,
  `Estado` char(13) NOT NULL,
  PRIMARY KEY (`ID_pelicula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "catalogo"
#

INSERT INTO `catalogo` VALUES (1,'Rey León','Infantil, Drama',2019,'Todos','Chiwetel Ejiofor, John Oliver','Jon Favreau','No disponible'),(2,'Titanic','Drama',1997,'+6años','Leonardo DiCaprio, Kate Winsle','James Cameron','Disponible'),(3,'Avengers: Los Vengadores','Acción, ficción',2012,'+4años','Robert Downey Jr., Chris Evans','Joss Whedon','Disponible');

#
# Structure for table "clientes"
#

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `Documento` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `Tel_fijo` int(7) NOT NULL,
  `Tel_celular` varchar(10) NOT NULL,
  `Direccion` varchar(60) NOT NULL,
  `Ciudad` varchar(30) NOT NULL,
  `Contraseña` int(4) NOT NULL,
  PRIMARY KEY (`Documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "clientes"
#

INSERT INTO `clientes` VALUES (32987152,'Luz María','López Castillo',5643598,'3116585987','CL 31 # 43-12','Bello',1234),(71639917,'Manuel Darío','Alvarez Muñoz',3314050,'3003197250','CR 27 # 36D SUR-280(802)','Envigado',9917),(92704358,'Ruben Darío','Ruiz Marín',2556203,'3004201250','CL 54 # 56-70','Medellín',4358);

#
# Structure for table "empleados"
#

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE `empleados` (
  `Documento` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `Tel_fijo` int(7) NOT NULL,
  `Tel_celular` varchar(10) NOT NULL,
  `Direccion` varchar(60) NOT NULL,
  `Ciudad` varchar(30) NOT NULL,
  `Nivel_Usu` int(2) NOT NULL,
  `Contraseña` int(4) NOT NULL,
  PRIMARY KEY (`Documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "empleados"
#

INSERT INTO `empleados` VALUES (85936541,'Jorge Luis','Pérez Coa',2984055,'3003197250','CR 27 # 36D SUR-280(802)','Sabaneta',1,9917),(96541238,'Luis Carlos','Ríos Pérez',2596209,'3004201250','CL 54 # 56-70','Itagüí',2,4358),(99332565,'Mary Luz','Mesa Suárez',5683591,'3116585987','CL 31 # 43-12','Medellín',2,1234);

#
# Structure for table "rentas"
#

DROP TABLE IF EXISTS `rentas`;
CREATE TABLE `rentas` (
  `ID_Tiket` int(10) NOT NULL,
  `Fecha_prestamo` date NOT NULL,
  `Fecha_retorno` date NOT NULL,
  `Cliente` int(11) NOT NULL,
  `Pelicula` int(6) NOT NULL,
  PRIMARY KEY (`ID_Tiket`),
  KEY `Cliente` (`Cliente`),
  KEY `Pelicula` (`Pelicula`),
  CONSTRAINT `rentas_ibfk_1` FOREIGN KEY (`Cliente`) REFERENCES `clientes` (`Documento`),
  CONSTRAINT `rentas_ibfk_2` FOREIGN KEY (`Pelicula`) REFERENCES `catalogo` (`ID_pelicula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "rentas"
#

INSERT INTO `rentas` VALUES (1,'2020-10-11','2020-10-28',71639917,1),(2,'2020-10-15','2020-10-30',71639917,3),(3,'2020-11-02','2020-11-15',92704358,2),(4,'2020-11-03','2020-11-14',92704358,3);
