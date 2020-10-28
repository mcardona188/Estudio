<%@page import="actividad4.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario)sesion.getAttribute("usuario");
            
        %>    
            
        <h1> Cliente: <%=usuario.getNombre() + " " + usuario.getApellidos() %></h1>
    </body>
</html>
