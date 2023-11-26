package com.delafuente.delafuente.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class Filtro {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate desde;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hasta;

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }
}
