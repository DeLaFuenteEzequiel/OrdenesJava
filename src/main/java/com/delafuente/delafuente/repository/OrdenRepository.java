package com.delafuente.delafuente.repository;

import com.delafuente.delafuente.model.Cliente;
import com.delafuente.delafuente.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    List<Orden> findByFechaBetween(LocalDate desde, LocalDate hasta);
}
