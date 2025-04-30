package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.models.Docentes;
 

public interface IDocentesService {

	List<Docentes> listar();
	
	Docentes consultarXId(Integer id);
		
		void eliminar(Integer id);
		
		Docentes editar(Docentes doc);
		
		Docentes registrar(Docentes doc);
}
