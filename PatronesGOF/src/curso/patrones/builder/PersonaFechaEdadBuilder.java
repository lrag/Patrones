package curso.patrones.builder;

import java.util.Calendar;

public class PersonaFechaEdadBuilder implements PersonaBuilder {
	Calendar calendar=Calendar.getInstance();
	Persona persona;

	public PersonaFechaEdadBuilder(Persona persona) {
		this.persona = persona;
	}
	
	public Persona construir(){
		if(persona.getEdad()!=0){
			calendar.set(calendar.get(Calendar.YEAR),0, 1,0,0,0);
			calendar.add(Calendar.YEAR, -persona.getEdad());
			persona.setFechaNacimiento(calendar.getTime());
			
		}else if(persona.getFechaNacimiento()!=null){
			int año=calendar.get(Calendar.YEAR);
			calendar.setTime(persona.getFechaNacimiento());
			persona.setEdad(año-calendar.get(Calendar.YEAR));
		}
		persona.setMayorEdad(persona.getEdad()>=18);
		return persona;
	}
}
