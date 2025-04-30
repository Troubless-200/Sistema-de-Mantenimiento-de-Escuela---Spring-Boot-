package com.cibertec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.models.Docentes;
 
import com.cibertec.app.repository.IDocentesRepository;
 

@Service
public class IDocentesImpl implements IDocentesService {

	@Autowired
	IDocentesRepository repositorioDocentes;
	
	@Override
	public List<Docentes> listar() {
		return (List<Docentes>)repositorioDocentes.findAll();
	}

	@Override
	public Docentes consultarXId(Integer id) {
		return repositorioDocentes.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioDocentes.deleteById(id);
	}

	@Override
	public Docentes editar(Docentes doc) {
		return repositorioDocentes.save(doc);
	}

	@Override
	public Docentes registrar(Docentes doc) {
		return repositorioDocentes.save(doc);
	}
}
