package com.api.crud.repositories;

import com.api.crud.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUEstudianteRepository extends JpaRepository<Estudiante, Long>{
}
