package com.api.crud.services;

import com.api.crud.models.Docente;
import com.api.crud.repositories.IDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona operaciones relacionadas con la entidad Docente.
 */
@Service
public class DocenteService {

    @Autowired
    private IDocenteRepository docenteRepository;

    /**
     * Obtiene todos los docentes.
     *
     * @return Lista de todos los docentes.
     */
    public List<Docente> getAll() {
        return docenteRepository.findAll();
    }

    /**
     * Guarda un nuevo docente.
     *
     * @param docente El docente a ser guardado.
     * @return El docente guardado.
     * @throws IllegalArgumentException Si ya existe un docente con el mismo tipo de documento y número de cédula.
     */
    public Docente save(Docente docente) {
        List<Docente> existingDocentes = docenteRepository.findByTipoDocAndNumeroDoc(docente.getTipoDoc(), docente.getNumeroDoc());

        if (!existingDocentes.isEmpty()) {
            throw new IllegalArgumentException("Ya existe un Docente con el mismo tipo de documento y número de cédula.");
        }

        return docenteRepository.save(docente);
    }

    /**
     * Obtiene un docente por su ID.
     *
     * @param id El ID del docente a buscar.
     * @return El docente con el ID proporcionado, o un Optional vacío si no se encuentra.
     */
    public Optional<Docente> getById(long id) {
        return docenteRepository.findById(id);
    }

    /**
     * Actualiza un docente por su ID.
     *
     * @param request Los nuevos datos del docente.
     * @param id      El ID del docente a ser actualizado.
     * @return El docente actualizado.
     * @throws IllegalArgumentException Si no se encuentra un docente con el ID proporcionado.
     */
    public Docente updateById(Docente request, Long id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if (optionalDocente.isPresent()) {
            Docente docente = optionalDocente.get();
            docente.setNombres(request.getNombres());
            docente.setApellidos(request.getApellidos());
            docente.setTipoDoc(request.getTipoDoc());
            docente.setNumeroDoc(request.getNumeroDoc());
            docente.setEspecialidad(request.getEspecialidad());
            docente.setGradoAcademico(request.getGradoAcademico());
            docente.setCorreoElectronico(request.getCorreoElectronico());

            return docenteRepository.save(docente);
        } else {
            throw new IllegalArgumentException("No se encontró un Docente con el ID proporcionado: " + id);
        }
    }

    /**
     * Elimina un docente por su ID.
     *
     * @param id El ID del docente a ser eliminado.
     * @return true si se eliminó exitosamente, false si no se encontró un docente con el ID proporcionado.
     */
    public boolean deleteDocente(Long id) {
        Optional<Docente> optionalDocente = docenteRepository.findById(id);

        if (optionalDocente.isPresent()) {
            docenteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

