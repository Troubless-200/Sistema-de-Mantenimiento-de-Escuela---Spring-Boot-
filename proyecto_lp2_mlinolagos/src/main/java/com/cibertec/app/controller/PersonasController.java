package com.cibertec.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.app.models.Personas;
import com.cibertec.app.service.IAlumnosService;
import com.cibertec.app.service.IPersonasService;

@Controller
@RequestMapping("/personas")
public class PersonasController {
	
	@Autowired
	IPersonasService servicioPersonas;
	
	@Autowired
	IAlumnosService servicioAlumnos;
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaPersonas", servicioPersonas.listar());
		return "/personas/inicio";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("personas", new Personas());
		model.addAttribute("listaPersonas", servicioPersonas.listar());
		model.addAttribute("listaAlumnos", servicioAlumnos.listar());
		return "/personas/crear";
	}
	
	@PostMapping("/crear")
	public String crear(Personas p) {
		System.out.println("ID Persona : "+ p.getIdpersona());
		System.out.println("Apellido : "+ p.getApellido());
		System.out.println("Nombre : "+ p.getNombre());
		System.out.println("rut : "+ p.getRut());
		servicioPersonas.registrar(p);
		return "redirect:/personas/inicio";
	}
	
	@GetMapping("/editar/{idpersona}")
	public String editar(@PathVariable Integer idpersona, Model model) {
		Personas objPer = servicioPersonas.consultarXId(idpersona);
		model.addAttribute("personas", objPer);
		
		
		return "/personas/editar";
	}
	
	@GetMapping("/eliminar/{idpersona}")
	public String eliminar(@PathVariable Integer idpersona, Model model) {
		Personas objPer = servicioPersonas.consultarXId(idpersona);
		model.addAttribute("personas", objPer);
		return "/personas/eliminar";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(Personas per) {
		servicioPersonas.eliminar(per.getIdpersona());
		return "redirect:/personas/inicio";
	}

    @Controller
    @RequestMapping("/Menu")
    public static class MenuController {

        @GetMapping("/InicioProyecto")
        public String InicioProyecto() {
            return"/Menu/InicioProyecto";
        }
    }
}
