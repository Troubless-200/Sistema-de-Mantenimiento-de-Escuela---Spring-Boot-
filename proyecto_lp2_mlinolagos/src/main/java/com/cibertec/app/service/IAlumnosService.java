package com.cibertec.app.service;

import java.util.List;


import com.cibertec.app.models.Alumnos;

public interface IAlumnosService {
	
	List<Alumnos> listar();
	
	Alumnos consultarXId(Integer id);
	
	void eliminar(Integer id);
	
	Alumnos editar(Alumnos alu);
	
	Alumnos registrar(Alumnos alu);
	


}