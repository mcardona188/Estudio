
<%@page import="actividad4.clases.Login"%>
<%@page import="actividad4.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loguin</title>
    </head>
    <body style="background-color:#B0E0E6;">
    <center>  
        <form action="">
            <p><input type="text" name="txtUsuario" id="txtUsuario"/></p>
            <p><input type="password" name="txtContra" id="txtContra"/></p>
            <p><input type="submit" name="btnIngresar" id="btnIngresar" value="Ingresar"/></p>
        </form>
    </center>
    <%
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("mensaje") != null) {
            %>
            <center><h4 style="color: red"><%=sesion.getAttribute("mensaje")%></h4></center>
            <%
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
    %>
</body>
</html>