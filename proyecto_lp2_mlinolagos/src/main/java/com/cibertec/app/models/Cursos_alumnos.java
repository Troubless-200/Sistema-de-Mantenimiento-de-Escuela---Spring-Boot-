package com.cibertec.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cursos_alumnos")
public class Cursos_alumnos {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer cursosalumnosid;
	
	@ManyToOne
	@JoinColumn(name="idcurso", nullable = false)
	private Cursos curso;
	
	@ManyToOne
	@JoinColumn(name= "idalumno")
	private Alumnos alumno;
	
	@Column(name= "nota", length = 60, nullable =false)
	private int nota;
	
	
	
 
	
	public Cursos_alumnos () {
		
	}





	public Cursos_alumnos(Integer cursosalumnosid, Cursos curso, Alumnos alumno, int nota) {
		super();
		this.cursosalumnosid = cursosalumnosid;
		this.curso = curso;
		this.alumno = alumno;
		this.nota = nota;
	}





	public Integer getCursosalumnosid() {
		return cursosalumnosid;
	}





	public void setCursosalumnosid(Integer cursosalumnosid) {
		this.cursosalumnosid = cursosalumnosid;
	}





	public Cursos getCurso() {
		return curso;
	}





	public void setCurso(Cursos curso) {
		this.curso = curso;
	}





	public Alumnos getAlumno() {
		return alumno;
	}





	public void setAlumno(Alumnos alumno) {
		this.alumno = alumno;
	}





	public int getNota() {
		return nota;
	}





	public void setNota(int nota) {
		this.nota = nota;
	}





	 





	 



 

	




	 

	


	 
	
}
