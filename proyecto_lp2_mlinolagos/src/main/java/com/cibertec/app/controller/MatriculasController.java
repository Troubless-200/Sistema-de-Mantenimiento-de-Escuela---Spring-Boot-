package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.app.models.Docentes;
import com.cibertec.app.models.Matriculas;
import com.cibertec.app.service.IAlumnosService;
import com.cibertec.app.service.IDocentesService;
import com.cibertec.app.service.IMatriculasService;

@Controller
@RequestMapping("/matriculas")
public class MatriculasController {

	
	@Autowired
	IMatriculasService ServicioMatriculas;
	
	@Autowired
	IAlumnosService ServicioAlumnos;
	
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaMatriculas", ServicioMatriculas.listar());
		return "/matriculas/inicio";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("matriculas", new Matriculas());
		model.addAttribute("listaAlumnos", ServicioAlumnos.listar());
		return "/matriculas/crear";
	}
	
	@PostMapping("/crear")
	public String crearMatriculas (Matriculas mat) {
		System.out.println("Idmatricula : "+  mat.getIdmatricula());
		System.out.println("fecha : "+  mat.getFecha());
		System.out.println("grado : "+mat.getGrado());
		System.out.println("id alumno : "+mat.getAlumno().getIdalumno());
		 
		ServicioMatriculas.registrar(mat);
		return "redirect:/matriculas/inicio";
	}
	
	@GetMapping("/editar/{idmatricula}")
	public String editar(@PathVariable Integer idmatricula, Model model) {
		Matriculas objMat = ServicioMatriculas.consultarXId(idmatricula);
		model.addAttribute("matriculas", objMat);
		model.addAttribute("listaAlumnos", ServicioAlumnos.listar());
		
		
		return "/matriculas/editar";
	}
	
	@GetMapping("/eliminar/{idmatricula}")
	public String eliminar(@PathVariable Integer idmatricula, Model model) {
		Matriculas objMat = ServicioMatriculas.consultarXId(idmatricula);
		model.addAttribute("matriculas", objMat);
		return "/matriculas/eliminar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(Matriculas mat) {
		ServicioMatriculas.eliminar(mat.getIdmatricula());
		return "redirect:/matriculas/inicio";
	}
	
}
