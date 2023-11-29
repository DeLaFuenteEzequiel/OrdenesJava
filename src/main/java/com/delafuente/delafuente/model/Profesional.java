package com.delafuente.delafuente.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesional;
    private String nombreApellido;
    private String especialidad;

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
    @OneToMany(mappedBy = "profesional")
    private List<Orden> ordenes;

    public Long getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(Long id_profesional) {
        this.id_profesional = id_profesional;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
