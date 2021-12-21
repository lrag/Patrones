package com.curso.modelo.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.util.DataSourceUtil;

public class ClienteRepositorioMysql implements ClienteRepositorio {

	//SINGLETÓN/////////////////////////////////////////////////////////
	
	private static ClienteRepositorioMysql instancia;
	
	public static synchronized ClienteRepositorioMysql getInstancia() {
		if(instancia == null) {
			instancia = new ClienteRepositorioMysql();
		}
		return instancia;
	}
	
	////////////////////////////////////////////////////////////////////

	private DataSource ds = DataSourceUtil.getDataSource();
	
	private ClienteRepositorioMysql() {
	}

	@Override
	public void insertar(Cliente cliente) {
		
		//Un repositorio/dao obteniendo una conexión...MAL
		try(Connection cx = ds.getConnection()){
			System.out.println("=====================================");
			System.out.println("Insertando en Mysql");
			System.out.println("Cliente:"+cliente);
			System.out.println("CX     :"+cx);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
}
