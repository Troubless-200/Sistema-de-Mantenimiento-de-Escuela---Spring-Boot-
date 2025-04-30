package com.cibertec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.models.Matriculas;
 
import com.cibertec.app.repository.IMatriculasRepository;
 

@Service
public class IMatriculasImpl implements IMatriculasService{


	@Autowired
	IMatriculasRepository repositorioMatriculas;
	
	@Override
	public List<Matriculas> listar() {
		return (List<Matriculas>)repositorioMatriculas.findAll();
	}

	@Override
	public Matriculas consultarXId(Integer id) {
		return repositorioMatriculas.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioMatriculas.deleteById(id);
	}

	@Override
	public Matriculas editar(Matriculas mat) {
		return repositorioMatriculas.save(mat);
	}

	@Override
	public Matriculas registrar(Matriculas mat) {
		return repositorioMatriculas.save(mat);
	}
}
