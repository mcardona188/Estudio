/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad4.clases;

import java.sql.Date;

/**
 *
 * @author Miguel Angel
 */
public class Renta {

    private Integer ID_Tiket;
    private Date fechaPrestamo;
    private Date fechaRetorno;
    private Usuario Cliente;
    private Pelicula pelicula;
    private MetodoPago metodoPago;

    public Integer getID_Tiket() {
        return ID_Tiket;
    }

    public void setID_Tiket(Integer ID_Tiket) {
        this.ID_Tiket = ID_Tiket;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public Usuario getCliente() {
        return Cliente;
    }

    public void setCliente(Usuario Cliente) {
        this.Cliente = Cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Renta{" + "ID_Tiket=" + ID_Tiket + ", fechaPrestamo=" + fechaPrestamo + ", fechaRetorno=" + fechaRetorno + ", Cliente=" + Cliente + ", pelicula=" + pelicula + ", metodoPago=" + metodoPago + '}';
    }
}
