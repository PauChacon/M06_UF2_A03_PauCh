package com.iticbcn.pauchacon.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "compania")
public class Compania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compania")
    private int idCompania;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "localidad", nullable = false)
    private String localidad;

    @OneToMany(mappedBy = "compania", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Trayecto> trayectos;


   

    public Compania() {
    }

    public Compania(int idCompania, String nombre, String localidad) {
        this.idCompania = idCompania;
        this.nombre = nombre;
        this.localidad = localidad;
        this.trayectos=trayectos;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

   

    public List<Trayecto> getTrayectos() {
        return trayectos;
    }

    public void setTrayectos(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    @Override
    public String toString() {
        return "Compania [idCompania=" + idCompania + ", nombre=" + nombre + ", localidad=" + localidad ;
    }
}
