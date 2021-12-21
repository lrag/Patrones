package com.curso.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.GestorClientes;
import com.curso.modelo.persistencia.RepositorioClientes;

//Spring creará una instancia de esta clase
//La llamará (si no indicamos lo contrario) 'clientesController'
//Le asignará el ámbito 'singleton'
@Controller
public class FormularioClientesController {
	
	@Autowired private GestorClientes gestorClientes;
	@Autowired private RepositorioClientes repositorioClientes;

	public FormularioClientesController() {
		super();
		//Esta traza solo saldrá una vez porque esto es un singleton
		System.out.println("Creando una instancia de FormularioClientesController");
	}	

	@GetMapping("/formularioClientes")	
	public ModelAndView verFormularioClientes() {
		System.out.println("FormularioClientesController.verFormularioClientes");
		ModelAndView mav = new ModelAndView("formularioClientes");
		mav.addObject("cliente", new Cliente());		
		return mav;
	}
	
	@GetMapping("/seleccionarCliente")
	public ModelAndView seleccionarCliente(@RequestParam("idCliente") Integer idCliente) {
		
		System.out.println("Seleccionar cliente:"+idCliente);
		
		/*
		Optional<Cliente> opC = repositorioClientes.findById(idCliente);
		Cliente c = null;
		if(opC.isPresent()) {
			c = opC.get();
		} else {
			c = new Cliente();
		}
		*/
		
		Cliente c = repositorioClientes.findById(idCliente).orElse(new Cliente());
		
		ModelAndView mav = new ModelAndView("formularioClientes");
		mav.addObject("cliente", c);
		return mav;
	}	

	//@Autowired
	//private ListadoClientesController listadoClientesController;
	
	@PostMapping("/insertarCliente")
	public ModelAndView insertarCliente(@Valid @ModelAttribute Cliente cliente, BindingResult br) {
		
		if(br.hasErrors()) {
			return new ModelAndView("formularioClientes");
		}
		
		gestorClientes.insertar(cliente);		
		//NO! SI LE DAN AL F5 SE INSERTA OTRA VEZ
		//Y además este método haría dos cosas: Insertar el cliente y MOSTRAR EL LISTADO! (no respeta el principio de responsabilidad única)
		//
		//ModelAndView mav = new ModelAndView(listadoClientes");
		//mav.addObject("listaClientes", repositorioClientes.findAll());
		//return mav;
		//ESTO ES TODAVÍA PEOR: LOS CONTROLADORES NO DEBEN CONOCERSE:
		//return listadoClientesController.verListadoClientes();
		//
		//POST-REDIRECT-GET
		ModelAndView mav = new ModelAndView("redirect:listadoClientes");
		return mav;
	}	
	
	@PostMapping("/modificarCliente")
	public ModelAndView modificarCliente(@ModelAttribute Cliente cliente) {
		System.out.println("FormularioClientesController.modificarCliente");

		gestorClientes.modificar(cliente);
		
		ModelAndView mav = new ModelAndView("redirect:listadoClientes");
		return mav;
	}
	
	@PostMapping("/borrarCliente")
	public ModelAndView borrarCliente(@ModelAttribute Cliente cliente) {
		System.out.println("FormularioClientesController.borrarCliente");

		gestorClientes.borrar(cliente);
		
		ModelAndView mav = new ModelAndView("redirect:listadoClientes");
		return mav;
	}
	
}















