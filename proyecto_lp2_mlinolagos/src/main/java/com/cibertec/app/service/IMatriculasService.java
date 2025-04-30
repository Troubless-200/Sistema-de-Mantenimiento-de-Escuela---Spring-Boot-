package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.models.Matriculas;


public interface IMatriculasService {

	
	List<Matriculas> listar();
	
	Matriculas consultarXId(Integer id);
		
		void eliminar(Integer id);
		
		Matriculas editar(Matriculas mat);
		
		Matriculas registrar(Matriculas mat);
}
