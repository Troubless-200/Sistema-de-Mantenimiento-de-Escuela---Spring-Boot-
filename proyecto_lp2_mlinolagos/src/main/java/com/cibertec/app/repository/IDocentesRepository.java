package com.cibertec.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.app.models.Docentes;

@Repository
public interface IDocentesRepository extends CrudRepository<Docentes, Integer> {

}
