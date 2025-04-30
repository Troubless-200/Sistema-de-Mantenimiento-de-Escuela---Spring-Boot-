package com.cibertec.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.app.models.Cursos;
import com.cibertec.app.models.Cursos_alumnos;

@Repository
public interface ICursos_AlumnosRepository extends CrudRepository<Cursos_alumnos, Integer> {

}
