package com.curso.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.curso.modelo.persistencia.RepositorioClientes;

//Spring creará una instancia de esta clase
//La llamará (si no indicamos lo contrario) 'clientesController'
//Le asignará el ámbito 'singleton'
@Controller
public class ListadoClientesController {

	@Autowired
	private RepositorioClientes repositorioClientes;
	
	public ListadoClientesController() {
		super();
		//Esta traza solo saldrá una vez porque esto es un singleton
		System.out.println("Creando una instancia de ListadoClientesController");
	}	
	
	@GetMapping(path = "/listadoClientes")
	public ModelAndView verListadoClientes() {
		System.out.println("ListadoClientesController.verListadoClientes");
		ModelAndView mav = new ModelAndView("listadoClientes");
		mav.addObject("listaClientes", repositorioClientes.findAll());
		return mav;
	}	
	
}
