package com.iticbcn.pauchacon.model;

import java.util.Set;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Trayecto {

    private int idTrayecto;
    private double precio;
    private String llegada;
    private String salida;
    private String hora;
    private int capacidad;
    private Compania compania;
    @OneToOne
    @JoinColumn(name = "id_tren")
    private Tren tren;
    private Set<Reserva> reservas; 

    public Trayecto() {
    }

    public Trayecto(int capacidad, Compania compania, String hora, int idTrayecto, String llegada, double precio, Set<Reserva> reservas, String salida, Tren tren) {
        this.capacidad = capacidad;
        this.compania = compania;
        this.hora = hora;
        this.idTrayecto = idTrayecto;
        this.llegada = llegada;
        this.precio = precio;
        this.reservas = reservas;
        this.salida = salida;
        this.tren = tren;
    }

    public int getIdTrayecto() {
        return idTrayecto;
    }

    public void setIdTrayecto(int idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trayecto{");
        sb.append("idTrayecto=").append(idTrayecto);
        sb.append(", precio=").append(precio);
        sb.append(", llegada=").append(llegada);
        sb.append(", salida=").append(salida);
        sb.append(", hora=").append(hora);
        sb.append(", capacidad=").append(capacidad);
        sb.append('}');
        return sb.toString();
    }
}
    