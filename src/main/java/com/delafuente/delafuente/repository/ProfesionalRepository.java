package com.delafuente.delafuente.repository;


import com.delafuente.delafuente.model.Orden;
import com.delafuente.delafuente.model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {

}
