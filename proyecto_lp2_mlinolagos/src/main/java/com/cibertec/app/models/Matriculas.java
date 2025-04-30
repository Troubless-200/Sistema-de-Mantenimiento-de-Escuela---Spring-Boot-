package com.cibertec.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="matriculas")
public class Matriculas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmatricula;
	
	@ManyToOne
	@JoinColumn(name = "idalumno", nullable = false)
	private Alumnos alumno;
	
	@Column(name="grado", length = 30, nullable = false)
	private String grado;
	    
	@Column(name="fecha", length = 12, nullable = false)
	private String fecha;
	
	public Matriculas() {
		
	
	}

	public Matriculas(Integer idmatricula, Alumnos alumno, String grado, String fecha) {
		super();
		this.idmatricula = idmatricula;
		this.alumno = alumno;
		this.grado = grado;
		this.fecha = fecha;
	}

	public Integer getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(Integer idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Alumnos getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
