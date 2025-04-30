package com.cibertec.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="docentes")
public class Docentes {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer iddocente;
	
	 @OneToOne
	 @JoinColumn(name = "idpersona", nullable = false)
	 private Personas persona;
	 
	 @Column(name ="tipocontrato", length = 20, nullable = false)
	 private String tipocontrato;
	 
	 public Docentes() {
		 
	 }

	public Docentes(Integer iddocente, Personas persona, String tipocontrato) {
		super();
		this.iddocente = iddocente;
		this.persona = persona;
		this.tipocontrato = tipocontrato;
	}

	public Integer getIddocente() {
		return iddocente;
	}

	public void setIddocente(Integer iddocente) {
		this.iddocente = iddocente;
	}

	public Personas getPersona() {
		return persona;
	}

	public void setPersona(Personas persona) {
		this.persona = persona;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}
	 
	 
}
