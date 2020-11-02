/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4.clases;

/**
 *
 * @author Miguel Angel
 */
public class Usuario {
    private String documento;
    private String Nombre;
    private String Apellidos;
    private String telFijo;
    private String telCelular;
    private String direccion;
    private String ciudad;
    private Integer nivelUsu;
    private Integer contrasena;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getNivelUsu() {
        return nivelUsu;
    }

    public void setNivelUsu(Integer nivelUsu) {
        this.nivelUsu = nivelUsu;
    }

    public Integer getContrasena() {
        return contrasena;
    }

    public void setContrasena(Integer contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "documento=" + documento + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", telFijo=" + telFijo + ", telCelular=" + telCelular + ", direccion=" + direccion + ", ciudad=" + ciudad + ", nivelUsu=" + nivelUsu + ", contrasena=" + contrasena + '}';
    }  
    
}
