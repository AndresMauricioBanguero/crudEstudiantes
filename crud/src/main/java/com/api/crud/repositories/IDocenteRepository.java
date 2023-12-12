package com.api.crud.repositories;

import com.api.crud.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteRepository extends JpaRepository<Docente, Long> {
}
