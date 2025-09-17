package com.curso.modelo.entidad;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Cliente_ActiveRecord implements Cloneable {

	private int id;
	private String codigo;
	private String nombre;
	private String direccion;
	private String telefono;
	
	private DataSource dataSource;

	public Cliente_ActiveRecord() {
		super();
	}

	public Cliente_ActiveRecord(int id, String codigo, String nombre, String direccion, String telefono) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return super.toString()+" [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
	
	@Override
	public Object clone() {
		return new Cliente_ActiveRecord(id, codigo, nombre, direccion, telefono);
	}

	//ACTIVE RECORD/////////////////////
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insertar() throws Exception {
		System.out.println("Insertandome en la bb.dd...");
		try {
			Connection cx = dataSource.getConnection();
			System.out.println(cx);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Fallo al acceder a la bb.dd");
		}
	}
	
	public void modificar() {
		System.out.println("Modificandome en la bb.dd...");
	}
	
	public void borrar() {
		System.out.println("Modificandome en la bb.dd...");
	}

}
