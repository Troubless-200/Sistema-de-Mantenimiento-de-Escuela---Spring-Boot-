package com.cibertec.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.app.models.Cursos;

@Repository
public interface ICursosRepository extends CrudRepository<Cursos, Integer> {

}
