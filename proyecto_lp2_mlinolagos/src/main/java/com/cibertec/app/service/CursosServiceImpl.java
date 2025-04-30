package com.cibertec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.models.Cursos;
 
import com.cibertec.app.repository.ICursosRepository;
 

@Service
public class CursosServiceImpl implements ICursosService{

	@Autowired
	ICursosRepository repositorioCursos;
	
	@Override
	public List<Cursos> listar() {
		return (List<Cursos>)repositorioCursos.findAll();
	}

	@Override
	public Cursos consultarXId(Integer id) {
		return repositorioCursos.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioCursos.deleteById(id);
	}

	@Override
	public Cursos editar(Cursos cur) {
		return repositorioCursos.save(cur);
	}

	@Override
	public Cursos registrar(Cursos cur) {
		return repositorioCursos.save(cur);
	}
}
