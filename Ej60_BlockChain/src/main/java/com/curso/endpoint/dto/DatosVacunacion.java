package com.curso.endpoint.dto;

public class DatosVacunacion {

	private String idCerdo;
	private String idVeterinario;

	public DatosVacunacion() {
		super();
	}

	public DatosVacunacion(String idCerdo, String idVeterinario) {
		super();
		this.idCerdo = idCerdo;
		this.idVeterinario = idVeterinario;
	}

	public String getIdCerdo() {
		return idCerdo;
	}

	public void setIdCerdo(String idCerdo) {
		this.idCerdo = idCerdo;
	}

	public String getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(String idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	@Override
	public String toString() {
		return "DatosVacunacion [idCerdo=" + idCerdo + ", idVeterinario=" + idVeterinario + "]";
	}

}
