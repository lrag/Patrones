package com.curso.endpoint;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.endpoint.dto.Mensaje;
import com.curso.endpoint.dto.PeliculaDTO;
import com.curso.modelo.negocio.ServicioPeliculas;
import com.curso.modelo.persistencia.PeliculaRepositorio;

import jakarta.validation.Valid;

@RestController
public class PeliculasREST {

	/*
	Api REST de Peliculas
	
	Método  Ruta             Body    Funcionalidad
	GET     /peliculas       -       listar
	GET     /peliculas/{id}  -      
	POST    /peliculas       {json}  insertar
	PUT     /peliculas/{id}  {json}
	DELETE  /peliculas/{id}  -
	*/
	
	private PeliculaRepositorio peliculaRepo;
	private ServicioPeliculas servicioPeliculas;
	
	public PeliculasREST(PeliculaRepositorio peliculaRepo, ServicioPeliculas servicioPeliculas) {
		super();
		this.peliculaRepo = peliculaRepo;
		this.servicioPeliculas = servicioPeliculas;
	}

	@PostMapping( 
			path = "/peliculas",
			consumes = "application/json"
		)
	public ResponseEntity<String> insertar(@Valid @RequestBody PeliculaDTO peliculaDto) throws Exception {
		servicioPeliculas.insertar(peliculaDto.asPelicula());
		return new ResponseEntity<String>("La pelicula se insertó", HttpStatus.CREATED);
	}
	
	@PutMapping( 
			path = "/peliculas/{id}",
			consumes = "application/json"
			)
	public ResponseEntity<String> modificar(@Valid @RequestBody PeliculaDTO peliculaDto) {
		servicioPeliculas.modificar(peliculaDto.asPelicula());
		return new ResponseEntity<String>("La película se modificó", HttpStatus.OK);
	}
	
	@GetMapping(
			path = "/peliculas",
			produces = "application/json"
		)
	public List<PeliculaDTO> listar() {
		return peliculaRepo
			.findAll()
			.stream()
			.map( p -> new PeliculaDTO(p))
			.collect(Collectors.toList());
	}
		
	@SuppressWarnings("unchecked")
	@GetMapping(
			path = "/peliculas/{id}",
			produces = "application/json"
		)
	public ResponseEntity<Object> buscar(@PathVariable("id") Integer id) {
		return peliculaRepo
			.findById(id)
			.map( pelicula -> new ResponseEntity(new PeliculaDTO(pelicula), HttpStatus.OK))
			.orElse( new ResponseEntity(new Mensaje("404", "La película no existe"), HttpStatus.NOT_FOUND));
	}	
	
	
	//
	// Si en todos los RestControler vamos a controlar así
	// los errores de validación lo mejor es dar de alta
	// este exception handler en un @ControlerAdvice
	//	
	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> errores = e.getBindingResult().getFieldErrors()
					.stream()
					.collect(Collectors.toMap( fe -> (String) fe.getField(), 
							                   fe -> (String) fe.getDefaultMessage()));
		return new ResponseEntity<Object>(errores, HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(Exception.class) //Esto sería 'NegocioException'
	@ResponseBody
	public ResponseEntity<?> handleNegocioException(Exception e) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(Throwable.class) 
	@ResponseBody
	public ResponseEntity<?> handle500(Throwable e) {
		return new ResponseEntity<Object>("ZASCA!", HttpStatus.INTERNAL_SERVER_ERROR);		
	}	
	*/	
	
		
}



