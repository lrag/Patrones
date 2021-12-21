package curso.patrones.comando;

public class MacroCmd implements Comando {
	Comando[] cmds;

	public MacroCmd(Comando[] cmds) {
		this.cmds = cmds;
	}

	public void deshacer() {
		for(Comando cmd:cmds)
			cmd.deshacer();

	}

	public void ejecutar() {
		for(Comando cmd:cmds)
			cmd.ejecutar();

	}

}
