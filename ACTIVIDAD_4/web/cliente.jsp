<%@page import="java.util.List"%>
<%@page import="actividad4.clases.Usuario"%>
<%@page import="actividad4.clases.Catalogo"%>
<%@page import="actividad4.clases.Renta"%>
<%@page import="actividad4.clases.Pelicula"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <center> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos.css">
        <title>Cliente</title>
        <center>  
            </head>
            <body>

                <div class="contenedor">
                    <center>
                        <h1>BIENVENIDO A MIS PELIS</h1>
                        <h1>Esta es tu información</h1>      

                        <%
                            HttpSession sesion = request.getSession();
                            Usuario usuario = (Usuario) sesion.getAttribute("usuario");

                            List<Renta> rentas = Catalogo.findRentas(usuario.getDocumento());
                            List<Pelicula> disponibles = Catalogo.findPeliculasDisponibles();
                        %>    

                        <h1> Cliente: <%=usuario.getNombre() + " " + usuario.getApellidos()%></h1>

                        <h2>Historial de rentas del usuario</h2>
                        <table border="1">
                            <tr>
                                <th>Pelicula</th>
                                <th>Género</th>
                                <th>Fecha préstamo</th>
                                <th>Fecha devolución</th>
                                <th>Tienda</th>
                            </tr>


                            <%
                                for (Renta renta : rentas) {

                            %>
                            <tr>
                                <td>
                                    <%=renta.getPelicula().getNombre()%>
                                </td>
                                <td>
                                    <%=renta.getPelicula().getGenero()%>
                                </td>
                                <td>
                                    <%=renta.getFechaPrestamo()%>
                                </td>
                                <td>
                                    <%=renta.getFechaRetorno()%>
                                </td>
                                <td>
                                    <%=renta.getPelicula().getTienda().getDireccion()%>
                                </td>
                            </tr>


                            <%
                                }
                            %>


                        </table>

                        <h2>Películas disponibles para alquilar</h2>
                        <table border="1">
                            <tr>
                                <th>Pelicula</th>
                                <th>Género</th>
                                <th>Año</th>
                                <th>Clasificación</th>
                                <th>Protagonistas</th>
                                <th>Director</th>
                                <th>Tienda</th>
                                <th>Acción</th>
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
                                <td>
                                    <form action="" method="post">
                                        <table>
                                            <tr>
                                                <td>
                                                    <label for="efectivo">Efectivo</label><br>
                                                    <input type="radio" id="efectivo" name="metodo_pago" value="1">
                                                </td>
                                                <td>
                                                    <label for="credito">Crédito</label><br>
                                                    <input type="radio" id="credito" name="metodo_pago" value="2">
                                                </td>
                                                <td>
                                                    <label for="debito">Débito</label><br>
                                                    <input type="radio" id="debito" name="metodo_pago" value="3">
                                                </td>                                
                                                <td>
                                                    <label for="pse">PSE</label><br>
                                                    <input type="radio" id="pse" name="metodo_pago" value="4">
                                                </td>
                                                <td><input type="submit" name="<%=pelicula.getIdPelicula()%>" id="alquilar" value="Alquilar"/></td>
                                            </tr>
                                        </table>
                                    </form>
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
