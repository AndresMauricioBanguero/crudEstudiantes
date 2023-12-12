package com.api.crud.repositories;

import com.api.crud.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz de repositorio para la entidad Docente.
 */
@Repository
public interface IDocenteRepository extends JpaRepository<Docente, Long> {

    /**
     * Método personalizado para buscar docentes por tipo de documento y número de documento.
     *
     * @param tipoDoc   El tipo de documento a buscar.
     * @param numeroDoc El número de documento a buscar.
     * @return Lista de docentes que coinciden con el tipo y número de documento proporcionados.
     */
    @Query("SELECT d FROM Docente d WHERE d.tipoDoc = :tipoDoc AND d.numeroDoc = :numeroDoc")
    List<Docente> findByTipoDocAndNumeroDoc(
            @Param("tipoDoc") String tipoDoc,
            @Param("numeroDoc") String numeroDoc
    );
}
