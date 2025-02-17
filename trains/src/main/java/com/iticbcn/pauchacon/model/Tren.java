package com.iticbcn.pauchacon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tren")
public class Tren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tren")
    private int idTren;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

   @OneToOne
    @JoinColumn(name = "id_tren") 
    private Trayecto trayecto;


    public Tren() {
    }

    public Tren(int idTren, String modelo, String nombre) {
        this.idTren = idTren;
        this.modelo = modelo;
        this.nombre = nombre;
    }

    public int getIdTren() {
        return idTren;
    }

    public void setIdTren(int idTren) {
        this.idTren = idTren;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Trayecto getTrayecto() {
        return trayecto;
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tren{");
        sb.append("idTren=").append(idTren);
        sb.append(", modelo=").append(modelo);
        sb.append(", nombre=").append(nombre);
        sb.append(", trayecto=").append(trayecto);
        sb.append('}');
        return sb.toString();
    }
}
