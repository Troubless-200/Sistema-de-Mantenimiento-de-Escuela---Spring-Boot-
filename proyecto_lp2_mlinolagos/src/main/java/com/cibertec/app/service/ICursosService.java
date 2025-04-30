package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.models.Cursos;


public interface ICursosService {

	List<Cursos> listar();
	
	Cursos consultarXId(Integer id);
		
		void eliminar(Integer id);
		
		Cursos editar(Cursos cur);
		
		Cursos registrar(Cursos cur);
}
