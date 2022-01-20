package com.curso.modelo.comando;

public class ComandoCrearCuenta {

	private long saldoInicial;
	private String cliente;

	public ComandoCrearCuenta() {
		super();
	}

	public ComandoCrearCuenta(long saldoInicial, String cliente) {
		super();
		this.saldoInicial = saldoInicial;
		this.cliente = cliente;
	}

	public long getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(long saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "ComandoCrearCuenta [saldoInicial=" + saldoInicial + ", cliente=" + cliente + "]";
	}

}
