package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import actividad4.clases.Login;
import actividad4.clases.Usuario;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilos.css\">\r\n");
      out.write("        <title>Loguin</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body class=\"bodyUno\">\r\n");
      out.write("        <center> \r\n");
      out.write("            <div>\r\n");
      out.write("                <h1>BIENVENIDO A MIS PELIS</h1>\r\n");
      out.write("                <h1>Ingresa tu usuario y contraseña</h1>\r\n");
      out.write("            </div>\r\n");
      out.write("         \r\n");
      out.write("            <form action=\"\">\r\n");
      out.write("                <p><input type=\"text\" name=\"txtUsuario\" id=\"txtUsuario\" placeholder=\"Documento\"/></p>\r\n");
      out.write("                <p><input type=\"password\" name=\"txtContra\" id=\"txtContra\" placeholder=\"Contraseña\"/></p>\r\n");
      out.write("                <p><input type=\"submit\" name=\"btnIngresar\" id=\"btnIngresar\" value=\"Ingresar\"/></p>\r\n");
      out.write("            </form>\r\n");
      out.write("        </center>\r\n");
      out.write("        ");

            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("mensaje") != null) {
        
      out.write("\r\n");
      out.write("        <center><h4 style=\"color: red\">");
      out.print(sesion.getAttribute("mensaje"));
      out.write("</h4></center>\r\n");
      out.write("            ");

                }
                if (request.getParameter("btnIngresar") != null) {
                    String documento = request.getParameter("txtUsuario");
                    Integer contrasena = Integer.parseInt(request.getParameter("txtContra"));
                    Usuario usuario = Login.validar(documento, contrasena);

                    switch (usuario.getNivelUsu()) {
                        case 0:
                            sesion.setAttribute("mensaje", "Usuario o contraseña inválido");
                            response.sendRedirect("login.jsp");
                            break;
                        case 1:
                            sesion.setAttribute("usuario", usuario);
                            response.sendRedirect("admin.jsp");
                            break;

                        case 2:
                            sesion.setAttribute("usuario", usuario);
                            response.sendRedirect("cliente.jsp");
                            break;

                        case 3:
                        default:
                            response.sendRedirect("error.jsp");

                    }
                }
            
      out.write("\r\n");
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
