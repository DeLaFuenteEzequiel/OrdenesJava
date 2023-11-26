package com.delafuente.delafuente.repository;

import com.delafuente.delafuente.model.Categoria;
import com.delafuente.delafuente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
