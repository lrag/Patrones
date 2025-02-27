package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

@SpringBootApplication
public class Aplicacion {

	public static void main(String[] args) {
		
		ApplicationContext appCtx =  SpringApplication.run(Aplicacion.class, args);
		
		/*
		ServicioPeliculas sp1 = (ServicioPeliculas) appCtx.getBean("servicioPeliculas");
		ServicioPeliculas sp2 = appCtx.getBean(ServicioPeliculas.class);
		System.out.println(sp1);
		System.out.println(sp2);
		Pelicula p = new Pelicula();
		sp1.insertar(p);
		sp2.insertar(p);
		*/
		
	}

}
