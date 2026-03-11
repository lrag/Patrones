package com.curso.modelo.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.curso.modelo.entidad.Factura;
import com.curso.modelo.persistencia.util.DataSourceUtil;

public class FacturaRepositorioMysql implements FacturaRepositorio {

	///////////////////////////////////////
	//ESTE NO ES UN SINGLETÓN//////////////
	//Y TIENE INYECCIÓN DE DEPENDENCIAS////
	///////////////////////////////////////
	
	private DataSource ds;
	
	public FacturaRepositorioMysql(DataSource ds) {
		super();
		this.ds = ds;
	}

	@Override
	public void insertar(Factura factura) {
		//Un repositorio/dao obteniendo una conexión...MAL
		try(Connection cx = ds.getConnection()){
			System.out.println("=====================================");
			System.out.println("Insertando en Mysql");
			System.out.println("Factura:"+factura);
			System.out.println("CX     :"+cx);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
