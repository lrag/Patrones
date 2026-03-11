package com.curso;

import javax.sql.DataSource;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.negocio.FactoriaServicioFacturas;
import com.curso.modelo.negocio.ServicioClientes;
import com.curso.modelo.negocio.ServicioFacturas;
import com.curso.modelo.persistencia.FacturaRepositorio;
import com.curso.modelo.persistencia.FacturaRepositorioMysql;
import com.curso.modelo.persistencia.util.DataSourceUtil;
import com.curso.modelo.persistencia.util.FactoriaFacturaRepositorio;

public class Prueba {

	public static void main(String[] args) {
		
		Cliente c = new Cliente(1,"Bart","C/Evergreen Terrace","555");
		
		ServicioClientes gc = ServicioClientes.getInstancia();
		gc.insertar(c);		
		
		//
		//Inyección de dependencias utilizando las factorías
		//
		
		//Clases varias
		DataSource ds = DataSourceUtil.getDataSource();
		
		//Repositorios
		FacturaRepositorio facturaRepo = FactoriaFacturaRepositorio.getFacturaRepositorio(ds);
		
		//Servicios
		ServicioFacturas servicioFacturas = FactoriaServicioFacturas.getServicioFacturas(facturaRepo);
		
		Factura f = new Factura();
		servicioFacturas.insertar(f);
		
		//
		//Y ya que estamos, inyección de dependencias sin utilizar las factorías 
		//
		
		DataSource ds2 = DataSourceUtil.getDataSource();
		FacturaRepositorio facturaRepositorio2 = new FacturaRepositorioMysql(ds2);
		ServicioFacturas servicioFacturas2 = new ServicioFacturas(facturaRepositorio2);;;;;;
		servicioFacturas2.insertar(f);
	}
	
}
