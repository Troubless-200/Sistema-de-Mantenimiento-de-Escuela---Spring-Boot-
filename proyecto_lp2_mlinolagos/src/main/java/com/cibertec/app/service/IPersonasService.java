package com.cibertec.app.service;

import java.util.List;

import com.cibertec.app.models.Personas;

public interface IPersonasService {
	
List<Personas> listar();
	
Personas consultarXId(Integer id);
	
	void eliminar(Integer id);
	
	Personas editar(Personas per);
	
	Personas registrar(Personas per);
}
