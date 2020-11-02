package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import actividad4.clases.Usuario;
import actividad4.clases.Catalogo;
import actividad4.clases.Renta;
import actividad4.clases.Pelicula;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilos.css\">\r\n");
      out.write("        <title>Administrador</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"contenedor\">\r\n");
      out.write("            <center>\r\n");
      out.write("                <h1>BIENVENIDO A MIS PELIS ADMINISTRADOR</h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                ");

                    HttpSession sesion = request.getSession();
                    Usuario administrador = (Usuario) sesion.getAttribute("usuario");

                    List<Usuario> clientes = Catalogo.findClientes();
                    List<Pelicula> disponibles = Catalogo.findPeliculasDisponibles();
                    List<Pelicula> alquiladas = Catalogo.findPeliculasAlquiladas();
                
      out.write("    \r\n");
      out.write("                <h1> Nombre: ");
      out.print(administrador.getNombre() + " " + administrador.getApellidos());
      out.write("</h1>\r\n");
      out.write("\r\n");
      out.write("                <h2>Listado de Clientes</h2>\r\n");
      out.write("                <table border=\"1\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Documento</th>\r\n");
      out.write("                        <th>Nombre completo</th>\r\n");
      out.write("                        <th>Tel_fijo</th>\r\n");
      out.write("                        <th>Celular</th>\r\n");
      out.write("                        <th>Direccion</th>\r\n");
      out.write("                        <th>Ciudad</th>\r\n");
      out.write("                        <th>Acción</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");

                        for (Usuario usuario : clientes) {
                    
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(usuario.getDocumento());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(usuario.getNombre() + " " + usuario.getApellidos());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(usuario.getTelFijo());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(usuario.getTelCelular());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(usuario.getDireccion());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(usuario.getCiudad());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <input type=\"submit\" name=\"");
      out.print(usuario.getDocumento());
      out.write("\" id=\"ver\" value=\"Ver usuario\"/>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                    
      out.write("            \r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("                <h2>Películas disponibles</h2>\r\n");
      out.write("                <table border=\"1\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Pelicula</th>\r\n");
      out.write("                        <th>Género</th>\r\n");
      out.write("                        <th>Año</th>\r\n");
      out.write("                        <th>Clasificación</th>\r\n");
      out.write("                        <th>Protagonistas</th>\r\n");
      out.write("                        <th>Director</th>\r\n");
      out.write("                        <th>Tienda</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        for (Pelicula pelicula : disponibles) {

                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getNombre());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getGenero());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getAnio());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getClasificacion());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getProtagonistas());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getDirector());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getTienda().getDireccion());
      out.write("\r\n");
      out.write("                        </td>                \r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <h2>Películas alquiladas</h2>\r\n");
      out.write("                <table border=\"1\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Pelicula</th>\r\n");
      out.write("                        <th>Género</th>\r\n");
      out.write("                        <th>Año</th>\r\n");
      out.write("                        <th>Clasificación</th>\r\n");
      out.write("                        <th>Protagonistas</th>\r\n");
      out.write("                        <th>Director</th>\r\n");
      out.write("                        <th>Tienda</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        for (Pelicula pelicula : alquiladas) {

                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getNombre());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getGenero());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getAnio());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getClasificacion());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getProtagonistas());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getDirector());
      out.write("\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            ");
      out.print(pelicula.getTienda().getDireccion());
      out.write("\r\n");
      out.write("                        </td>                \r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </center>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
