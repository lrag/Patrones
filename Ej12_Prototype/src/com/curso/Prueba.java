package com.curso;

import java.time.LocalDate;
import java.util.List;

import com.curso.modelo.entidad.Cliente_ActiveRecord;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Producto;

public class Prueba {

	public static void main(String[] args) throws Exception {
		
		
		Cliente_ActiveRecord c = new Cliente_ActiveRecord(1,"CLI-1","Harry Callahan","C/Falsa,123","555123");
		
		Producto p1 = new Producto(1,"PROD-1","Chisme","Chismes de Santa Pola S.A.");
		Producto p2 = new Producto(2,"PROD-2","Bártulo","Ibérica de Bártulos S.A.");
		Producto p3 = new Producto(2,"PROD-3","Artilugio","Artilugios Reunidos S.A.");

		DetalleFactura df1 = new DetalleFactura(1,1d,10d,p1);
		DetalleFactura df2 = new DetalleFactura(2,1d,20d,p2);
		DetalleFactura df3 = new DetalleFactura(3,1d,30d,p3);
		DetalleFactura df4 = new DetalleFactura(4,1d,10d,p1);
		DetalleFactura df5 = new DetalleFactura(5,1d,5d ,p1);
		
		List<DetalleFactura> detalles = List.of(df1,df2,df3,df4,df5);
		
		Factura f1 = new Factura(1,"FAC-1", LocalDate.now(), c, detalles);
		Factura f2 = (Factura) f1.clone();
		
		System.out.println("==============================================");
		System.out.println(f1);
		System.out.println("----------------------------------------------");
		System.out.println(f2);
		System.out.println("==============================================");
		System.out.println(f1.getCliente());
		System.out.println("----------------------------------------------");
		System.out.println(f2.getCliente());
		System.out.println("==============================================");
		f1.getDetalles().forEach(df -> System.out.println(df));
		System.out.println("----------------------------------------------");
		f2.getDetalles().forEach(df -> System.out.println(df));
		System.out.println("==============================================");
		f1.getDetalles().forEach(df -> System.out.println(df.getProducto()));
		System.out.println("----------------------------------------------");
		f2.getDetalles().forEach(df -> System.out.println(df.getProducto()));
		
	}
	
}


/*
class Cliente {
	
	private String nombre;
	private String direccion;	
	private String telefono;	
	private DataSource dataSource;
	
	public static Cliente getInstancia(String nombre, String direccion, String telefono) {

		Cliente c = new Cliente();
		c.nombre = nombre;
		c.direccion = direccion;
		c.telefono = telefono;
		c.dataSource = DataSourceUtil.getDataSource();		
		
		return c;
		
	}
	
	
	private Cliente() {
		
	}
	
	
}
*/






