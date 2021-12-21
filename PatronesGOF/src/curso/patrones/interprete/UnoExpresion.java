package curso.patrones.interprete;

public class UnoExpresion extends Expresion {

	@Override
	public String uno() {
		// TODO Auto-generated method stub
		return "I";
	}

	@Override
	public String cuatro() {
		// TODO Auto-generated method stub
		return "IV";
	}

	@Override
	public String cinco() {
		// TODO Auto-generated method stub
		return "V";
	}

	@Override
	public String nueve() {
		// TODO Auto-generated method stub
		return "IX";
	}

	@Override
	public int multiplicador() {
		// TODO Auto-generated method stub
		return 1;
	}

}
