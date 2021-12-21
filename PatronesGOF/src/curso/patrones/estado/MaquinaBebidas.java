package curso.patrones.estado;

public class MaquinaBebidas {
	Estado sinBebidaEstado=new SinBebidaEstado(this);
	Estado noHayMonedaEstado=new NoHayMonedaEstado(this);
	Estado hayMonedaEstado=new HayMonedaEstado(this);
	Estado bebidaVendidaEstado=new BebidaVendidaEstado(this);
	
	Estado estado=sinBebidaEstado;
	int contador=0;
	
	public MaquinaBebidas(int contador) {
		this.contador=contador;
		if(contador>0){
			estado=noHayMonedaEstado;
		}
	}

	public void insertarMoneda(){
		estado.insertarMoneda();
	}
	
	
	public void devolverMoneda(){
		estado.devolverMoneda();
	}
	

	public void pulsarBoton(){
		estado.pulsarBoton();
	}

	
	public void dispensar() {
		estado.dispensar();
		
	}
	
	public void reponer(int cantidad){
		System.out.println("reponiendo "+cantidad);
		contador+=cantidad;
		if(contador>0)
			estado=noHayMonedaEstado;
		System.out.println("total="+contador);
		
		
	}
	
	@Override
	public String toString() {
		return "estado :"+estado.getClass().getSimpleName()+" uds:"+contador ;
	}

	public Estado getSinBebidaEstado() {
		return sinBebidaEstado;
	}

	public void setSinBebidaEstado(Estado sinBebidaEstado) {
		this.sinBebidaEstado = sinBebidaEstado;
	}

	public Estado getNoHayMonedaEstado() {
		return noHayMonedaEstado;
	}

	public void setNoHayMonedaEstado(Estado noHayMonedaEstado) {
		this.noHayMonedaEstado = noHayMonedaEstado;
	}

	public Estado getHayMonedaEstado() {
		return hayMonedaEstado;
	}

	public void setHayMonedaEstado(Estado hayMonedaEstado) {
		this.hayMonedaEstado = hayMonedaEstado;
	}

	public Estado getBebidaVendidaEstado() {
		return bebidaVendidaEstado;
	}

	public void setBebidaVendidaEstado(Estado bebidaVendidaEstado) {
		this.bebidaVendidaEstado = bebidaVendidaEstado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

}
