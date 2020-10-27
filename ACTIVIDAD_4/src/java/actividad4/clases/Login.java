/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4.clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Miguel Angel
 */
public class Login {

    public boolean validar(String documento, String contrasena) {
        Connection cnx = null;
        Statement sta = null;
        ResultSet rs = null;
        try {
            cnx = Conexion.getConnection();

            sta = cnx.createStatement();
            rs = sta.executeQuery("select * from usuarios where Documento='85936541' and Contrasena=9917");
            if (rs.next()){
                return true;
                
            }
           
        } catch (Exception e) {
        }
                
        return false;

    }
    public static void main(String[] arg){
        Login login=new Login();
        boolean valido=login.validar("documento", "contrasena");
        System.out.println(valido);
        
    }

}
