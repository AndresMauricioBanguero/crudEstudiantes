package com.api.crud.controller;

import com.api.crud.models.Docente;
import com.api.crud.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Controlador para gestionar las operaciones relacionadas con los docentes.
 */
@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    /**
     * Obtiene todos los docentes registrados.
     *
     * @return Lista de docentes.
     */
    @GetMapping
    public ResponseEntity<ArrayList<Docente>> getAll() {
        return ResponseEntity.ok((ArrayList<Docente>) docenteService.getAll());
    }

    /**
     * Crea un nuevo docente.
     *
     * @param docente Datos del docente a crear.
     * @return Docente creado.
     */
    @PostMapping
    public Docente save(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    /**
     * Obtiene un docente por su ID.
     *
     * @param id ID del docente.
     * @return Docente con el ID especificado, si existe.
     */
    @GetMapping(path = "/{id}")
    public Optional<Docente> getDocenteByID(@PathVariable("id") Long id) {
        return docenteService.getById(id);
    }

    /**
     * Actualiza la información de un docente existente.
     *
     * @param request Datos actualizados del docente.
     * @param id      ID del docente a actualizar.
     * @return Docente actualizado, si existe.
     */
    @PutMapping(path = "/{id}")
    public Docente updateDocenteById(@RequestBody Docente request, @PathVariable("id") Long id) {
        return docenteService.updateById(request, id);
    }

    /**
     * Elimina un docente por su ID.
     *
     * @param id ID del docente a eliminar.
     * @return Mensaje indicando si el docente fue borrado o no.
     */
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = docenteService.deleteDocente(id);
        if (ok) {
            return "Docente con ID " + id + " borrado";
        } else {
            return "Docente con ID " + id + " no fue borrado o no existe";
        }
    }
}
