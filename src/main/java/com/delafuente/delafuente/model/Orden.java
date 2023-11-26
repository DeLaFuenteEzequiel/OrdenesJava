package com.delafuente.delafuente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@Entity
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orden;
    @NotEmpty(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El costo es obligatorio")
    @Min(value = 0, message = "El costo no puede ser negativo")
    private double costo;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotEmpty(message = "El estado es obligatorio")
    private String estado;

    @ManyToOne()
    @JoinColumn(name = "dni")
    @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @NotNull(message = "La categoría es obligatoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_profesional")
    @NotNull(message = "El profesional es obligatorio")
    private Profesional profesional;


    public Long getId_orden() {
        return id_orden;
    }

    public void setId_orden(Long id_orden) {
        this.id_orden = id_orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
}
