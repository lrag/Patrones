package curso.patrones.prototipo;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Soldado implements Cloneable, Serializable{
	String rango;
	Color color;
	String arma;
	Vector poderes=new Vector();
	
	public Soldado() {
	
	}

	public Soldado(String rango, Color color, String arma) {
		this.rango = rango;
		this.color = color;
		this.arma = arma;
		
	}

	//HORROR
//	public Soldado(Soldado soldado) {
//		this.rango = soldado.rango;
//		this.color = soldado.color;
//		this.arma = soldado.arma;
//	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
	
	@Override
	public String toString() {
		return 	rango+","+color+","+arma+","+poderes.hashCode();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object clon= super.clone();
		((Soldado)clon).poderes= (Vector) poderes.clone();
		return clon;
	}
	
	public Object clonacionProfunda(){
		Soldado clon=null;
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("objeto.ser"));
			oos.writeObject(this);
			oos.flush();
			oos.close();
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("objeto.ser"));
			clon=(Soldado) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clon;
	}
	
	
}
