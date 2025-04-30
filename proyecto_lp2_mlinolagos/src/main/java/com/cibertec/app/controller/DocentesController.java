package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cibertec.app.models.Docentes;
import com.cibertec.app.models.Personas;
import com.cibertec.app.service.IDocentesService;
import com.cibertec.app.service.IPersonasService;

@Controller
@RequestMapping("/docentes")
public class DocentesController{
	
	@Autowired
	IDocentesService ServicioDocentes;
	
	@Autowired
	IPersonasService servicioPersonas;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaDocentes", ServicioDocentes.listar());
		return "/docentes/inicio";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("docentes", new Docentes());
		model.addAttribute("listaPersonas", servicioPersonas.listar());
		return "/docentes/crear";
	}
	
	@PostMapping("/crear")
	public String crear(Docentes doc) {
		System.out.println("Id docente : "+  doc.getIddocente());
		System.out.println("tipocontrato : "+  doc.getTipocontrato());
		System.out.println("Id persona : "+ doc.getPersona().getIdpersona());
		 
		ServicioDocentes.registrar(doc);
		return "redirect:/docentes/inicio";
	}
	
	@GetMapping("/editar/{iddocente}")
	public String editar(@PathVariable Integer iddocente,  Model model) {
		Docentes objDoc = ServicioDocentes.consultarXId(iddocente);
		model.addAttribute("docentes", objDoc);
		model.addAttribute("listaPersonas", servicioPersonas.listar());
		
		
		return "/docentes/editar";
	}
	
	@GetMapping("/eliminar/{iddocente}")
	public String eliminar(@PathVariable Integer iddocente, Model model) {
		Docentes objDoc = ServicioDocentes.consultarXId(iddocente);
		model.addAttribute("docentes", objDoc);
		return "/docentes/eliminar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(Docentes doc) {
		ServicioDocentes.eliminar(doc.getIddocente());
		return "redirect:/docentes/inicio";
	}
	
	
}