package com.api.crud.controller;

import com.api.crud.models.Docente;
import com.api.crud.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public ResponseEntity<ArrayList<Docente>> getAll() {
        return ResponseEntity.ok(docenteService.getAll());
    }

    @PostMapping
    public Docente save(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    @GetMapping(path = "/{id}")
    public Optional<Docente> getDocenteByID(@PathVariable("id") Long id) {
        return docenteService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Docente updateDocenteById(@RequestBody Docente request, @PathVariable("id") Long id) {
        return docenteService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = docenteService.deleteDocente(id);
        if (ok) {
            return "Docente con id " + id + " borrado";
        } else {
            return "Docente con id " + id + " no fue borrado";
        }
    }
}
