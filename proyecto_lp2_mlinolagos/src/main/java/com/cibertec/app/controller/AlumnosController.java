package com.cibertec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cibertec.app.models.Alumnos;
import com.cibertec.app.models.Personas;
import com.cibertec.app.service.IAlumnosService;
import com.cibertec.app.service.IMatriculasService;
import com.cibertec.app.service.IPersonasService;

@Controller
@RequestMapping("/alumnos")
public class AlumnosController {
	
	@Autowired
	IAlumnosService servicioAlumnos;
	
	@Autowired
	IPersonasService servicioPersonas;
	
	@Autowired
	IMatriculasService servicioMatriculas;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		
		List<Alumnos> lista= servicioAlumnos.listar();
		model.addAttribute("listaAlumnos", lista);
		
		return "/alumnos/inicio";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("alumnos", new Alumnos());
		model.addAttribute("listaPersonas", servicioPersonas.listar());
		return "/alumnos/crear";
	}
	
	@PostMapping("/crear")
	public String crear(Alumnos alumnos) {
		System.out.println("ID Alumno : "+ alumnos.getIdalumno());
		System.out.println("ID Persona : " +alumnos.getPersona().getIdpersona());
		System.out.println("Carrera : "+ alumnos.getCarrera());
		System.out.println("Facultad : "+ alumnos.getFacultad());
		
		servicioAlumnos.registrar(alumnos);
		return "redirect:/alumnos/inicio";
	}
	
	@GetMapping("/editar/{idalumno}")
	public String editar(@PathVariable Integer idalumno, Model model) {
		Alumnos objAlu = servicioAlumnos.consultarXId(idalumno);
		model.addAttribute("alumnos", objAlu);
		model.addAttribute("listaPersonas", servicioPersonas.listar());
		
		return "/alumnos/editar";
	}
	
	@GetMapping("/eliminar/{idalumno}")
	public String eliminar(@PathVariable Integer idalumno, Model model) {
		Alumnos objAlu = servicioAlumnos.consultarXId(idalumno);
		model.addAttribute("alumnos", objAlu);
		return "/alumnos/eliminar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(Alumnos alu) {
		servicioAlumnos.eliminar(alu.getIdalumno());
		
		return "redirect:/alumnos/inicio";
	}
	
}
