package curso.patrones.builder;

import java.util.Date;

public class Persona {
	private String nombre;
	private int edad;
	private float altura;
	
	private Date fechaNacimiento;
	private boolean mayorEdad;
	
	public Persona() {}

	public Persona(String nombre, int edad, float altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
	}

	public Persona(String nombre, Date fechaNacimiento, float altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}
	
	@Override
	public String toString() {
		return nombre+","+edad+","+altura+","+fechaNacimiento+","+edad;
	}
}
