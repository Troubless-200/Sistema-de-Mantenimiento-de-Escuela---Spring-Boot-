package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cibertec.app.models.Cursos_alumnos;
import com.cibertec.app.service.IAlumnosService;
import com.cibertec.app.service.ICursosService;
import com.cibertec.app.service.ICursos_alumnosService;
 

@Controller
@RequestMapping("/cursos_alumnos")
public class Cursos_alumnosController {


	@Autowired
	ICursos_alumnosService ServicioCursos_alumnos;
	
	@Autowired
	ICursosService ServicioCursos;
	
	@Autowired
	IAlumnosService ServicioAlumnos;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaCursos_alumnos", ServicioCursos_alumnos.listar());
		return "/cursos_alumnos/inicio";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("cursosalumnos", new Cursos_alumnos());
		model.addAttribute("listaCursos", ServicioCursos.listar());
		model.addAttribute("listaAlumnos", ServicioAlumnos.listar());
		return "/cursos_alumnos/crear";
	}
	
	@PostMapping("/crear")
	public String crear(Cursos_alumnos cura) {
		System.out.println("cursos alumnos id : "+ cura.getCursosalumnosid());
		System.out.println("Id curso : "+ cura.getCurso().getIdcurso());
		System.out.println("Id alumno : "+ cura.getAlumno().getIdalumno());
		System.out.println("Nota : "+ cura.getNota());
		ServicioCursos_alumnos.registrar(cura);
		return "redirect:/cursos_alumnos/inicio";
	}
	
	@GetMapping("/editar/{cursosalumnosid}")
	public String editar(@PathVariable Integer curso, Model model) {
		Cursos_alumnos objCura = ServicioCursos_alumnos.consultarXId(curso);
		model.addAttribute("cursosalumnos", objCura);
		model.addAttribute("listaAlumnos", ServicioAlumnos.listar());
		
		
		return "/cursos_alumnos/editar";
	}
	
	@GetMapping("/eliminar/{cursosalumnosid}")
	public String eliminar(@PathVariable Integer cura, Model model) {
		Cursos_alumnos objCura = ServicioCursos_alumnos.consultarXId(cura);
		model.addAttribute("cursosalumnos", objCura);
		return "/cursos_alumnos/eliminar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(Cursos_alumnos cura) {
		ServicioCursos_alumnos.eliminar(cura.getCursosalumnosid());
		return "redirect:/cursos_alumnos/inicio";
	}
}
