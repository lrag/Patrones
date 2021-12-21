package curso.patrones.estado.problema;

public class MaquinaBebidas {
	final static int NO_HAY_MONEDA=0;
	final static int HAY_MONEDA=1;
	final static int BEBIDA_VENDIDA=2;
	final static int SIN_BEBIDA=3;
	
	int estado=SIN_BEBIDA;
	int contador=0;
	
	public MaquinaBebidas(int contador) {
		this.contador=contador;
		if(contador>0){
			estado=NO_HAY_MONEDA;
		}
	}
	
	public void insertarMoneda(){
		if(estado==NO_HAY_MONEDA){
			System.out.println("moneda insertada.");
			estado=HAY_MONEDA;
		}else if(estado==HAY_MONEDA){
			System.out.println("ya hay una moneda.");
		}else if(estado==BEBIDA_VENDIDA){
			System.out.println("espere, sirviendo bebida");
		}else if(estado==SIN_BEBIDA){
			System.out.println("sin bebidas, no puede inservar moneda.");
		}
	}
	
	public void devolverMoneda(){
		if(estado==NO_HAY_MONEDA){
			System.out.println("no hay moneda insertada.");
		}else if(estado==HAY_MONEDA){
			System.out.println("devolviendo una moneda.");
			estado=NO_HAY_MONEDA;
		}else if(estado==BEBIDA_VENDIDA){
			System.out.println("espere, sirviendo bebida");
		}else if(estado==SIN_BEBIDA){
			System.out.println("sin bebidas, no se puede devolver moneda.");
		}
	}
	
	public void pulsarBoton(){
		if(estado==NO_HAY_MONEDA){
			System.out.println("no hay moneda insertada.");
		}else if(estado==HAY_MONEDA){
			System.out.println("preparando para servir bebida...");
			estado=BEBIDA_VENDIDA;
			dispensar();
		}else if(estado==BEBIDA_VENDIDA){
			System.out.println("espere, sirviendo bebida");
		}else if(estado==SIN_BEBIDA){
			System.out.println("sin bebidas, no se puede servir.");
		}
	}

	public void dispensar() {
		if(estado==NO_HAY_MONEDA){
			System.out.println("No hay moneda, insertela y pulse el boton");
		}else if(estado==HAY_MONEDA){
			System.out.println("hay moneda, pulse el boton");
		}else if(estado==BEBIDA_VENDIDA){
			System.out.println("tome su bebida");
			contador--;
			if(contador>0)
				estado=NO_HAY_MONEDA;
			else
				estado=SIN_BEBIDA;
		}else if(estado==SIN_BEBIDA){
			System.out.println("sin bebidas, no se puede servir.");
		}
		
	}
	
	public void reponer(int cantidad){
		System.out.println("reponiendo "+cantidad);
		contador+=cantidad;
		if(contador>0)
			estado=NO_HAY_MONEDA;
		System.out.println("total="+contador);
		
		
	}
	
	@Override
	public String toString() {
		String cadEstado="";
		switch (estado) {
		case NO_HAY_MONEDA:cadEstado="NO_HAY_MONEDA";break;
		case HAY_MONEDA:cadEstado="HAY_MONEDA";break;
		case BEBIDA_VENDIDA:cadEstado="BEBIDA_VENDIDA";break;
		case SIN_BEBIDA:cadEstado="SIN_BEBIDA";break;
		}
		return "estado :"+cadEstado+" uds:"+contador ;
	}

}
