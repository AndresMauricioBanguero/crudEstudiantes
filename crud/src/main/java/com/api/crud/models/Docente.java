package com.api.crud.models;

import jakarta.persistence.*;

/**
 * Clase que representa la entidad "Docente" en la base de datos.
 */
@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombres;

    private String apellidos;
    private String tipoDoc;
    private String numeroDoc;
    private String especialidad;
    private String gradoAcademico;
    private String correoElectronico;

    /**
     * Constructor sin argumentos requerido por JPA.
     */
    public Docente() {
    }

    /**
     * Constructor utilizado para crear una instancia de Docente con todos los atributos.
     *
     * @param id               El identificador único del docente.
     * @param nombres          Los nombres del docente.
     * @param apellidos        Los apellidos del docente.
     * @param tipoDoc          El tipo de documento del docente.
     * @param numeroDoc        El número de documento del docente.
     * @param especialidad     La especialidad del docente.
     * @param gradoAcademico   El grado académico del docente.
     * @param correoElectronico El correo electrónico del docente.
     */
    public Docente(Long id, String nombres, String apellidos, String tipoDoc, String numeroDoc, String especialidad, String gradoAcademico, String correoElectronico) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDoc = tipoDoc;
        this.numeroDoc = numeroDoc;
        this.especialidad = especialidad;
        this.gradoAcademico = gradoAcademico;
        this.correoElectronico = correoElectronico;
    }

    // Métodos getters y setters (accesores y mutadores) para cada atributo:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Método toString para representar la información del docente como una cadena de texto.
     *
     * @return Representación en cadena de texto del objeto Docente.
     */
    @Override
    public String toString() {
        return "Docente{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", tipoDoc='" + tipoDoc + '\'' +
                ", numeroDoc='" + numeroDoc + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", gradoAcademico='" + gradoAcademico + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
