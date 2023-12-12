package com.api.crud.services;

import com.api.crud.controller.Autowired;
import com.api.crud.models.Estudiante;
import com.api.crud.repositories.IUEstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EstudianteService {
 @Autowired
    private IUEstudianteRepository estudianteRepository;
    public ArrayList<Estudiante> getAll() {
        return (ArrayList<Estudiante>)estudianteRepository.findAll();
    }
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }
     public Optional<Estudiante> getById(long id){
        return estudianteRepository.findById(id);
     }
    public Estudiante updateById(Estudiante request,Long id){
        Estudiante estudiante=estudianteRepository.findById(id).get();
        estudiante.setNombres(request.getNombres());
        estudiante.setApellidos(request.getApellidos());
        estudiante.setTipoDoc(request.getTipoDoc());
        estudiante.setNumeroDoc(request.getNumeroDoc());
        return estudiante;
    }
    public Boolean deleteEstudiante(Long id){
        try {
            estudianteRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
