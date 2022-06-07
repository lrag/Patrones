package _02_sOlid_Principio_de_abierto_cerrado_ejemplo3;

public interface AltaProductoStrategy {

	//Lo normal es que el método de la estrategia se llame ejecutar, pero
	//que no se llame así nohace que esto deje de ser un Strategy
	void ejecutar(Producto producto);

}
