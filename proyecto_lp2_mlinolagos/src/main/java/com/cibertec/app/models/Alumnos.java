package com.cibertec.app.models;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
@Table(name ="alumnos")
public class Alumnos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idalumno;
	
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Personas persona; 
	
	@Column(name="carrera", length = 35, nullable = false)
	private String carrera;
	
	@Column(name="facultad", length = 35, nullable = false)
	private String facultad;
	
	
	public Alumnos() {
		
	}


	public Alumnos(Integer idalumno, Personas persona, String carrera, String facultad) {
		super();
		this.idalumno = idalumno;
		this.persona = persona;
		this.carrera = carrera;
		this.facultad = facultad;
	}


	public Integer getIdalumno() {
		return idalumno;
	}


	public void setIdalumno(Integer idalumno) {
		this.idalumno = idalumno;
	}


	public Personas getPersona() {
		return persona;
	}


	public void setPersona(Personas persona) {
		this.persona = persona;
	}


	public String getCarrera() {
		return carrera;
	}


	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	public String getFacultad() {
		return facultad;
	}


	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}


	 
	
	

	 
	 
}
