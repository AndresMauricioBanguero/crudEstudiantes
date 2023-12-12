package com.api.crud.models;

import jakarta.persistence.*;

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
}
