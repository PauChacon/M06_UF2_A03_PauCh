package com.iticbcn.pauchacon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int idReserva;
    @Column(name = "id_cliente", nullable = false)
    private int idCliente;

    @Column(name = "coste_total", nullable = false)
    private double costeTotal;

    @Column(name = "fecha", nullable = false)
    private String fecha;

       @ManyToOne
    @JoinColumn(name = "id_trayecto", nullable = false)
    private Trayecto trayecto;


    public Reserva() {
    }

    public Reserva(int idReserva, int idCliente, double costeTotal, String fecha) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.costeTotal = costeTotal;
        this.fecha = fecha;
        this.trayecto=trayecto;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Trayecto getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

 
}
