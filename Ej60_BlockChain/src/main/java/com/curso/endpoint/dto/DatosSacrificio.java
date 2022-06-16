package com.curso.endpoint.dto;

public class DatosSacrificio {

	private String idCerdo;
	private String idMatadero;

	public DatosSacrificio() {
		super();
	}

	public DatosSacrificio(String idCerdo, String idMatadero) {
		super();
		this.idCerdo = idCerdo;
		this.idMatadero = idMatadero;
	}

	public String getIdCerdo() {
		return idCerdo;
	}

	public void setIdCerdo(String idCerdo) {
		this.idCerdo = idCerdo;
	}

	public String getIdMatadero() {
		return idMatadero;
	}

	public void setIdMatadero(String idMatadero) {
		this.idMatadero = idMatadero;
	}

	@Override
	public String toString() {
		return "DatosSacrificio [idCerdo=" + idCerdo + ", idMatadero=" + idMatadero + "]";
	}

}
