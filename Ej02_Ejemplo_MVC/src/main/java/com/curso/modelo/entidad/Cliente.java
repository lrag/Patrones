package com.curso.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//Obligatoria
@Entity
//Opcional. Si no se indica se usa el nombre de la clase como nombre de la tabla
@Table(name = "cliente")
public class Cliente {

	//Obligatoria
	@Id
	//Opcional
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String nombre;

	@NotBlank
	private String direccion;
	
	@NotBlank
	private String telefono;
	
	@NotBlank
	@Email
	@Column(name="correo_e")
	private String correoE;
	
	private Boolean activo;
	private String notas;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono, String correoE, Boolean activo,
			String notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
		this.activo = activo;
		this.notas = notas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", correoE=" + correoE + ", activo=" + activo + ", notas=" + notas + "]";
	}
	
}
