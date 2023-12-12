package com.api.crud.controller;

import com.api.crud.models.Estudiante;
import com.api.crud.repositories.IUEstudianteRepository;
import com.api.crud.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;
    @GetMapping
    public ResponseEntity<ArrayList<Estudiante>> getAll() {
        return ResponseEntity.ok(estudianteService.getAll());
    }
    @PostMapping
    public Estudiante save(@RequestBody Estudiante estudiante){
        return this.estudianteService.save(estudiante);
    }
    @GetMapping(path = "/{id}")
    public Optional<Estudiante> getEstudianteByID(@PathVariable("id")Long id) {
        return this.estudianteService.getById(id);
    }
    @PutMapping(path = "/{id}")
    public Estudiante updateEstudianteById(@RequestBody Estudiante request,@PathVariable("id")Long id){
        return this.estudianteService.updateById(request, id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Long id){
        boolean ok = this.estudianteService.deleteEstudiante(id);
        if(ok){
            return "Estudiante con id " + id + " borrado";
        } else {
            return "Estudiante con id " + id + " no fue borrado";
        }
    }
}