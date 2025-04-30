package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.models.Cursos;
import com.cibertec.app.models.Cursos_alumnos;


public interface ICursos_alumnosService {

	List<Cursos_alumnos> listar();
	
	Cursos_alumnos consultarXId(Integer id);
		
		void eliminar(Integer id);
		
		Cursos_alumnos editar(Cursos_alumnos cura);
		
		Cursos_alumnos registrar(Cursos_alumnos cura);
}
