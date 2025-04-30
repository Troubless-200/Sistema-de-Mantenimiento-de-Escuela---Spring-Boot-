package com.cibertec.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="personas")
public class Personas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpersona;
	
	@Column(name="nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name="apellido", length = 35, nullable = false)
	private String apellido;
	
	@Column(name="rut", length = 10, nullable = false)
	private String rut;

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public Personas(Integer idpersona, String nombre, String apellido, String rut) {
		super();
		this.idpersona = idpersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}
	
	public Personas() {
		
	}
}
