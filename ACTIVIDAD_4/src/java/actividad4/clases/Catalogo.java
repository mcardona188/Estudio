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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Angel
 */
public class Catalogo {

    public static Tienda findTienda(String codigo) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Tienda tienda = new Tienda();

        try {
            cnx = Conexion.getConnection();
            String query = "select * from tiendas where codigo =?";
            p = cnx.prepareStatement(query);
            p.setString(1, codigo);
            rs = p.executeQuery();

            if (rs.next()) {
                tienda.setCodigo(codigo);
                tienda.setDireccion(rs.getString("Direccion"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return tienda;
    }

    public static MetodoPago findMetodoPago(int id) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        MetodoPago metodoPago = new MetodoPago();

        try {
            cnx = Conexion.getConnection();
            String query = "select * from metodos_pago where id =?";
            p = cnx.prepareStatement(query);
            p.setInt(1, id);
            rs = p.executeQuery();

            if (rs.next()) {
                metodoPago.setId(id);
                metodoPago.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return metodoPago;
    }

    public static Usuario findUsuario(String documento) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();

        try {
            cnx = Conexion.getConnection();
            String query = "select * from usuarios where Documento =?";
            p = cnx.prepareStatement(query);
            p.setString(1, documento);
            rs = p.executeQuery();

            if (rs.next()) {
                usuario.setDocumento(documento);
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
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return usuario;
    }

    public static Pelicula findPelicula(int id) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Pelicula pelicula = new Pelicula();

        try {
            cnx = Conexion.getConnection();
            String query = "select * from catalogo where ID_pelicula =?";
            p = cnx.prepareStatement(query);
            p.setInt(1, id);
            rs = p.executeQuery();

            if (rs.next()) {
                pelicula.setIdPelicula(id);
                pelicula.setNombre(rs.getString("Nombre"));
                pelicula.setGenero(rs.getString("Genero"));
                pelicula.setAnio(rs.getInt("anio"));
                pelicula.setClasificacion(rs.getString("Clasificacion"));
                pelicula.setProtagonistas(rs.getString("Protagonistas"));
                pelicula.setDirector(rs.getString("Director"));
                pelicula.setEstado(rs.getString("Estado"));

                Tienda tienda = findTienda(rs.getString("tienda"));
                pelicula.setTienda(tienda);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return pelicula;
    }

    public static Renta findRenta(int id) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        Renta renta = new Renta();

        try {
            cnx = Conexion.getConnection();
            String query = "select * from rentas where ID_Tiket =?";
            p = cnx.prepareStatement(query);
            p.setInt(1, id);
            rs = p.executeQuery();

            if (rs.next()) {
                renta.setID_Tiket(id);
                renta.setFechaPrestamo(rs.getDate("Fecha_prestamo"));
                renta.setFechaRetorno(rs.getDate("Fecha_retorno"));
                
                Usuario usuario = findUsuario(rs.getString("Cliente"));
                renta.setCliente(usuario);
                
                Pelicula pelicula = findPelicula(rs.getInt("Pelicula"));
                renta.setPelicula(pelicula);
                
                MetodoPago metodoPago = findMetodoPago(rs.getInt("metodo_pago"));
                renta.setMetodoPago(metodoPago);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return renta;
    }
    
    public static List<Renta> findRentas(String documento) throws SQLException {
        Connection cnx = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        List<Renta> rentas = new ArrayList();

        try {
            cnx = Conexion.getConnection();
            String query = "select * from rentas where Cliente =?";
            p = cnx.prepareStatement(query);
            p.setString(1, documento);
            rs = p.executeQuery();

            while (rs.next()) {
                Renta renta = new Renta();
                renta.setID_Tiket(rs.getInt("ID_Tiket"));
                renta.setFechaPrestamo(rs.getDate("Fecha_prestamo"));
                renta.setFechaRetorno(rs.getDate("Fecha_retorno"));
                
                Usuario usuario = findUsuario(rs.getString("Cliente"));
                renta.setCliente(usuario);
                
                Pelicula pelicula = findPelicula(rs.getInt("Pelicula"));
                renta.setPelicula(pelicula);
                
                MetodoPago metodoPago = findMetodoPago(rs.getInt("metodo_pago"));
                renta.setMetodoPago(metodoPago);
                
                rentas.add(renta);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            p.close();
            cnx.close();
        }

        return rentas;
    }

    public static void main(String[] asd) throws SQLException {
        System.err.println(Catalogo.findTienda("0001"));
        System.err.println(Catalogo.findMetodoPago(1));
        System.err.println(Catalogo.findPelicula(1));
        System.err.println(Catalogo.findUsuario("85936541"));
        System.err.println(Catalogo.findRenta(1));
        
        System.err.println("*******************");
        System.err.println(Catalogo.findRentas("99332565"));
    }
}
