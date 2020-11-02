use videotienda;

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