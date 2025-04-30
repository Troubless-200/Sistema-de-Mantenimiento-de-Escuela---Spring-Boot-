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
@Table(name="cursos")
public class Cursos {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer idcurso;
	
	@ManyToOne
	@JoinColumn(name="iddocente", nullable = false)
	private Docentes docentes;
	
	@Column(name= "nombrecurso", length = 50, nullable =false)
	private String nombrecurso;
	
	@Column(name= "horas", length = 10, nullable =false)
	private Integer horas;
	
	public Cursos () {
		
	}

	public Cursos(Integer idcurso, Docentes docentes, String nombrecurso, Integer horas) {
		super();
		this.idcurso = idcurso;
		this.docentes = docentes;
		this.nombrecurso = nombrecurso;
		this.horas = horas;
	}

	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public Docentes getDocentes() {
		return docentes;
	}

	public void setDocentes(Docentes docentes) {
		this.docentes = docentes;
	}

	public String getNombrecurso() {
		return nombrecurso;
	}

	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	
	
	
	
}
