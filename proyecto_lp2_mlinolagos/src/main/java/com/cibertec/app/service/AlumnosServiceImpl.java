package com.cibertec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.models.Alumnos;
import com.cibertec.app.repository.IAlumnosRepository;

@Service
public class AlumnosServiceImpl implements IAlumnosService {

	@Autowired
	IAlumnosRepository repositorioAlumnos;

	@Override
	public List<Alumnos> listar() {
		return (List<Alumnos>) repositorioAlumnos.findAll();
	}

	@Override
	public Alumnos consultarXId(Integer id) {
		return repositorioAlumnos.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioAlumnos.deleteById(id);
	}

	@Override
	public Alumnos editar(Alumnos alu) {
		return repositorioAlumnos.save(alu);
	}

	@Override
	public Alumnos registrar(Alumnos alu) {
		return repositorioAlumnos.save(alu);
	}

}