package com.curso.modelo.comando;

import java.util.UUID;

public class ComandoRetirarCuenta {

	private UUID idCuenta;
	private long cantidad;

	public ComandoRetirarCuenta() {
		super();
	}

	public ComandoRetirarCuenta(UUID idCuenta, long cantidad) {
		super();
		this.idCuenta = idCuenta;
		this.cantidad = cantidad;
	}

	public UUID getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(UUID idCuenta) {
		this.idCuenta = idCuenta;
	}

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ComandoIngresoCuenta [idCuenta=" + idCuenta + ", cantidad=" + cantidad + "]";
	}

}
