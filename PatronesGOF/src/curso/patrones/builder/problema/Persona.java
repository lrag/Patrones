package curso.patrones.builder.problema;

import java.util.Calendar;
import java.util.Date;

public class Persona {
	Calendar calendar=Calendar.getInstance();
	private String nombre;
	private int edad;
	private float altura;
	
	private Date fechaNacimiento;
	private boolean mayorEdad;
	
	public Persona() {}

	public Persona(String nombre, int edad, float altura) {
		this.nombre = nombre;
		this.setEdad(edad);
		this.altura = altura;
	}

	public Persona(String nombre, Date fechaNacimiento,float altura) {
		this.nombre = nombre;
		this.altura = altura;
		this.setFechaNacimiento(fechaNacimiento);
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
		calendar.set(calendar.get(Calendar.YEAR),0, 1,0,0,0);
		
		calendar.add(Calendar.YEAR, -edad);
		fechaNacimiento=calendar.getTime();
		mayorEdad=edad>=18;
	
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
		int año=calendar.get(Calendar.YEAR);
		calendar.setTime(fechaNacimiento);
		
		edad=año-calendar.get(Calendar.YEAR);
		mayorEdad=edad>=18;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	
	@Override
	public String toString() {
		return nombre+","+edad+","+altura+","+fechaNacimiento+","+mayorEdad;
	}
}
