/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Miguel Angel
 */
public class Conexion {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection cnx = null;
        Statement sta = null;
        Class.forName("com.mysql.jdbc.Driver");
        cnx = DriverManager.getConnection("jdbc:mysql://localhost/videotienda?user=root&password=");
        return cnx;

    }
    
}
