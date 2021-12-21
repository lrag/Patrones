package curso.patrones.visitante;

import java.beans.Visibility;

public class VisitanteVeterinariaPreciosMayoryMenor implements VisitanteVeterinaria {

	double pvpMayor=Integer.MIN_VALUE;
	double pvpMenor=Integer.MAX_VALUE;
	double importeActual=0;
	
	public void visitarAnimal(Animal a) {
		importeActual=a.getPrecio();
		if(importeActual<pvpMenor)
			pvpMenor=importeActual;
		if(importeActual>pvpMayor)
			pvpMayor=importeActual;
		
	}

	public void visitarArticulo(Articulo a) {
		importeActual=a.getImporte();
		if(importeActual<pvpMenor)
			pvpMenor=importeActual;
		if(importeActual>pvpMayor)
			pvpMayor=importeActual;
		
	}

	public double getPvpMayor() {
		return pvpMayor;
	}

	public void setPvpMayor(double pvpMayor) {
		this.pvpMayor = pvpMayor;
	}

	public double getPvpMenor() {
		return pvpMenor;
	}

	public void setPvpMenor(double pvpMenor) {
		this.pvpMenor = pvpMenor;
	}




}
