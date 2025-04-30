package com.cibertec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.app.models.Cursos;
import com.cibertec.app.models.Cursos_alumnos;
import com.cibertec.app.repository.ICursosRepository;
import com.cibertec.app.repository.ICursos_AlumnosRepository;
 

@Service
public class Cursos_alumnosServiceImpl implements ICursos_alumnosService{

	@Autowired
	ICursos_AlumnosRepository repositorioCursos_alumnos;
	
	@Override
	public List<Cursos_alumnos> listar() {
		return (List<Cursos_alumnos>)repositorioCursos_alumnos.findAll();
	}

	@Override
	public Cursos_alumnos consultarXId(Integer id) {
		return repositorioCursos_alumnos.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioCursos_alumnos.deleteById(id);
	}

	@Override
	public Cursos_alumnos editar(Cursos_alumnos cura) {
		return repositorioCursos_alumnos.save(cura);
	}

	@Override
	public Cursos_alumnos registrar(Cursos_alumnos cura) {
		return repositorioCursos_alumnos.save(cura);
	}
}
