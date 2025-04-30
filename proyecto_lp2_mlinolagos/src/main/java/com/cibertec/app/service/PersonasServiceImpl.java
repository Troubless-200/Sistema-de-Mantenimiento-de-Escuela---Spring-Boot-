package com.cibertec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cibertec.app.models.Personas;
import com.cibertec.app.repository.IPersonasRepository;

@Service
public class PersonasServiceImpl implements IPersonasService{

	@Autowired
	IPersonasRepository repositorioPersonas;
	
	@Override
	public List<Personas> listar() {
		return (List<Personas>)repositorioPersonas.findAll();
	}

	@Override
	public Personas consultarXId(Integer id) {
		return repositorioPersonas.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioPersonas.deleteById(id);
	}

	@Override
	public Personas editar(Personas per) {
		return repositorioPersonas.save(per);
	}

	@Override
	public Personas registrar(Personas per) {
		return repositorioPersonas.save(per);
	}

}
