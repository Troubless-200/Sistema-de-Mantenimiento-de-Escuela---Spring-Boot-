package com.cibertec.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.app.models.Personas;

@Repository
public interface IPersonasRepository extends CrudRepository<Personas, Integer> {

}
