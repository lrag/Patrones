package com.curso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.CobroFactura;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.EventoFactura;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Producto;
import com.curso.modelo.entidad.builder.FacturaBuilderImplementation;

public class Prueba {

	public static void main(String[] args) {
		
		Cliente c = new Cliente(1,"CLI-1","Harry Callahan","C/Falsa,123","555123");
		
		Producto p1 = new Producto(1,"PROD-1","Chisme","Chismes de Santa Pola S.A.");
		Producto p2 = new Producto(2,"PROD-2","B�rtulo","Ib�rica de B�rtulos S.A.");
		Producto p3 = new Producto(2,"PROD-3","Artilugio","Artilugios Reunidos S.A.");

		DetalleFactura df1 = new DetalleFactura(1,1d,10d,p1);
		DetalleFactura df2 = new DetalleFactura(2,1d,20d,p2);
		DetalleFactura df3 = new DetalleFactura(3,1d,30d,p3);
		DetalleFactura df4 = new DetalleFactura(4,1d,10d,p1);
		DetalleFactura df5 = new DetalleFactura(5,1d,5d ,p1);
		List<DetalleFactura> detalles = List.of(df1,df2,df3,df4,df5);
		
		CobroFactura cb1 = new CobroFactura(1,LocalDate.now(),20d);
		CobroFactura cb2 = new CobroFactura(2,LocalDate.now(),20d);
		CobroFactura cb3 = new CobroFactura(3,LocalDate.now(),35d);
		List<CobroFactura> cobros = List.of(cb1,cb2,cb3);
		
		EventoFactura ef1 = new EventoFactura(1, LocalDateTime.now(),"Tal");
		EventoFactura ef2 = new EventoFactura(2, LocalDateTime.now(),"Pascual");
		EventoFactura ef3 = new EventoFactura(3, LocalDateTime.now(),"Tal y pascual");
		List<EventoFactura> eventos = List.of(ef1,ef2,ef3);
		
		//Raro es que tengamos todos los valores
		//Factura f0 = new Factura(1, "FAC-1", LocalDate.now(), c, detalles, cobros, eventos);
		
		Factura f1 = new FacturaBuilderImplementation("FAC-1", LocalDate.now())
				.id(1)
				.cliente(c)
				.detalles(detalles)
				.cobros(cobros)
				.eventos(eventos)
				.build();

		Factura f2 = new FacturaBuilderImplementation()
				.id(1)
				.codigo("FAC-1")
				.fecha(LocalDate.now())
				.cliente(c)
				.detalles(detalles)
				.cobros(cobros)
				.eventos(eventos)
				.build();
		
		//Sin el 'fluent api' esto es horrible
		FacturaBuilderImplementation fbi = new FacturaBuilderImplementation();
		fbi.id(1);
		fbi.codigo("FAC-2");
		fbi.cliente(c);
		//...
		Factura f3 = fbi.build();
		
		
		
		System.out.println("==============================================");
		System.out.println(f1);
		System.out.println(f1.getCliente());
		f1.getDetalles().forEach(df -> System.out.println(df));
		f1.getDetalles().forEach(df -> System.out.println(df.getProducto()));
		f1.getCobros().forEach(cobro -> System.out.println(cobro));
		f1.getEventos().forEach(e -> System.out.println(e));
		
	}

}
