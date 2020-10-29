/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Miguel Angel
 */
public class Login {

    public static Usuario validar(String documento, int contrasena) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        usuario.setNivelUsu(0);

        try {
            cnx = Conexion.getConnection();
            String query = "select * from usuarios where Documento=? and Contrasena=?";
            p = cnx.prepareStatement(query);
            p.setString(1, documento);
            p.setInt(2, contrasena);
            rs = p.executeQuery();

            if (rs.next()) {
                usuario.setDocumento(rs.getString("Documento"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setTelFijo(rs.getString("Tel_fijo"));
                usuario.setTelCelular(rs.getString("Tel_celular"));
                usuario.setDireccion(rs.getString("Direccion"));
                usuario.setCiudad(rs.getString("Ciudad"));
                usuario.setNivelUsu(rs.getInt("Nivel_Usu"));
                usuario.setContrasena(rs.getInt("Contrasena"));
            }
        } catch (Exception e) {
            usuario.setNivelUsu(3);
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return usuario;
    }
    
    
    public static void main(String[] asd) throws SQLException {
        System.err.println(Login.validar("85936541", 9917));
    }
}
