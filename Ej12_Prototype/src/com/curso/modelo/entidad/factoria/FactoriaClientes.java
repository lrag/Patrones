package com.curso.modelo.entidad.factoria;

import com.curso.modelo.entidad.Cliente_ActiveRecord;
import com.curso.modelo.persistencia.util.DataSourceUtil;

public class FactoriaClientes {

	public Cliente_ActiveRecord createCliente() {
		Cliente_ActiveRecord cliente = new Cliente_ActiveRecord();
		cliente.setDataSource(DataSourceUtil.getDataSource());
		return cliente;
	}
	
	public Cliente_ActiveRecord createCliente(int id, String codigo, String nombre, String direccion, String telefono) {
		Cliente_ActiveRecord cliente = new Cliente_ActiveRecord();
		cliente.setId(id);
		cliente.setCodigo(codigo);
		cliente.setNombre(nombre);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setDataSource(DataSourceUtil.getDataSource());
		return cliente;
	}
	
}
