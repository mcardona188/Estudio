<%-- 
    Document   : admin
    Created on : 28-oct-2020, 8:18:55
    Author     : Miguel Angel
--%>

<%@page import="java.util.List"%>
<%@page import="actividad4.clases.Usuario"%>
<%@page import="actividad4.clases.Catalogo"%>
<%@page import="actividad4.clases.Renta"%>
<%@page import="actividad4.clases.Pelicula"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css">
        <title>Administrador</title>
    </head>

    <body>
        <div class="contenedor">
            <center>
                <h1>BIENVENIDO A MIS PELIS ADMINISTRADOR</h1>


                <%
                    HttpSession sesion = request.getSession();
                    Usuario administrador = (Usuario) sesion.getAttribute("usuario");

                    List<Usuario> clientes = Catalogo.findClientes();
                    List<Pelicula> disponibles = Catalogo.findPeliculasDisponibles();
                    List<Pelicula> alquiladas = Catalogo.findPeliculasAlquiladas();
                %>    
                <h1> Nombre: <%=administrador.getNombre() + " " + administrador.getApellidos()%></h1>

                <h2>Listado de Clientes</h2>
                <table border="1">
                    <tr>
                        <th>Documento</th>
                        <th>Nombre completo</th>
                        <th>Tel_fijo</th>
                        <th>Celular</th>
                        <th>Direccion</th>
                        <th>Ciudad</th>
                        <th>Acción</th>
                    </tr>
                    <%
                        for (Usuario usuario : clientes) {
                    %>
                    <tr>
                        <td>
                            <%=usuario.getDocumento()%>
                        </td>
                        <td>
                            <%=usuario.getNombre() + " " + usuario.getApellidos()%>
                        </td>
                        <td>
                            <%=usuario.getTelFijo()%>
                        </td>
                        <td>
                            <%=usuario.getTelCelular()%>
                        </td>
                        <td>
                            <%=usuario.getDireccion()%>
                        </td>
                        <td>
                            <%=usuario.getCiudad()%>
                        </td>
                        <td>
                            <input type="submit" name="<%=usuario.getDocumento()%>" id="ver" value="Ver usuario"/>
                        </td>
                    </tr>


                    <%
                        }
                    %>            
                </table>

                <h2>Películas disponibles</h2>
                <table border="1">
                    <tr>
                        <th>Pelicula</th>
                        <th>Género</th>
                        <th>Año</th>
                        <th>Clasificación</th>
                        <th>Protagonistas</th>
                        <th>Director</th>
                        <th>Tienda</th>
                    </tr>

                    <%
                        for (Pelicula pelicula : disponibles) {

                    %>

                    <tr>
                        <td>
                            <%=pelicula.getNombre()%>
                        </td>
                        <td>
                            <%=pelicula.getGenero()%>
                        </td>
                        <td>
                            <%=pelicula.getAnio()%>
                        </td>
                        <td>
                            <%=pelicula.getClasificacion()%>
                        </td>
                        <td>
                            <%=pelicula.getProtagonistas()%>
                        </td>
                        <td>
                            <%=pelicula.getDirector()%>
                        </td>
                        <td>
                            <%=pelicula.getTienda().getDireccion()%>
                        </td>                
                    </tr>

                    <%
                        }
                    %>
                </table>


                <h2>Películas alquiladas</h2>
                <table border="1">
                    <tr>
                        <th>Pelicula</th>
                        <th>Género</th>
                        <th>Año</th>
                        <th>Clasificación</th>
                        <th>Protagonistas</th>
                        <th>Director</th>
                        <th>Tienda</th>
                    </tr>

                    <%
                        for (Pelicula pelicula : alquiladas) {

                    %>

                    <tr>
                        <td>
                            <%=pelicula.getNombre()%>
                        </td>
                        <td>
                            <%=pelicula.getGenero()%>
                        </td>
                        <td>
                            <%=pelicula.getAnio()%>
                        </td>
                        <td>
                            <%=pelicula.getClasificacion()%>
                        </td>
                        <td>
                            <%=pelicula.getProtagonistas()%>
                        </td>
                        <td>
                            <%=pelicula.getDirector()%>
                        </td>
                        <td>
                            <%=pelicula.getTienda().getDireccion()%>
                        </td>                
                    </tr>

                    <%
                        }
                    %>
                </table>
            </center>
        </div>
    </body>
</html>