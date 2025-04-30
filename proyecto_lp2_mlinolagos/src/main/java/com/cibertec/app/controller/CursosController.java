package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.app.models.Cursos;
 
 
import com.cibertec.app.service.ICursosService;
import com.cibertec.app.service.IDocentesService;
 

@Controller
@RequestMapping("/cursos")
public class CursosController {


 
	
	@Autowired
	ICursosService ServicioCursos;
	
	@Autowired
	IDocentesService ServicioDocentes;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaCursos", ServicioCursos.listar());
		return "/cursos/inicio";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("cursos", new Cursos());
		model.addAttribute("listaDocentes", ServicioDocentes.listar());
		return "/cursos/crear";
	}
	
	@PostMapping("/crear")
	public String crear(Cursos cur) {
		System.out.println("Id curso : "+ cur.getIdcurso());
		System.out.println("nombre curso : "+ cur.getNombrecurso());
		System.out.println("horas : "+ cur.getHoras());
		System.out.println("Id docente : "+ cur.getDocentes().getIddocente());
		ServicioCursos.registrar(cur);
		return "redirect:/cursos/inicio";
	}
	
	@GetMapping("/editar/{idcurso}")
	public String editar(@PathVariable Integer idcurso, Model model) {
		Cursos objCur = ServicioCursos.consultarXId(idcurso);
		model.addAttribute("cursos", objCur);
		model.addAttribute("listaDocentes", ServicioDocentes.listar());
		
		return "/cursos/editar";
	}
	
	@GetMapping("/eliminar/{idcurso}")
	public String eliminar(@PathVariable Integer idcurso, Model model) {
		Cursos objCur = ServicioCursos.consultarXId(idcurso);
		model.addAttribute("cursos", objCur);
		return "/cursos/eliminar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(Cursos cur) {
		ServicioCursos.eliminar(cur.getIdcurso());
		return "redirect:/cursos/inicio";
	}
}
