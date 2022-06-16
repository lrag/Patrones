package com.curso.endpoint.dto;

import java.math.BigInteger;

import org.web3j.tuples.generated.Tuple5;

/*
struct Cerdo {
    string id;
    bool   vacunado;
    bool   sacrificado;
    string raza;
    string idGanadero;
    string idVeterinario;
    string idMatadero;
}
*/

public class CerdoDTO {

	private String id;
	private boolean vacunado;
	private boolean procesado;
	private String raza;
	private String idGanadero;
	private String idVeterinario;
	private String idMatadero;

	public CerdoDTO() {
		super();
	}

	public CerdoDTO(String id, boolean vacunado, boolean procesado, String raza, String idGanadero,
			String idVeterinario, String idMatadero) {
		super();
		this.id = id;
		this.vacunado = vacunado;
		this.procesado = procesado;
		this.raza = raza;
		this.idGanadero = idGanadero;
		this.idVeterinario = idVeterinario;
		this.idMatadero = idMatadero;
	}

	public CerdoDTO(Tuple5<String, String, String, String, String> respuesta) {
		id = respuesta.component1();
		raza = respuesta.component2();
		idGanadero = respuesta.component3();
		idVeterinario = respuesta.component4();
		idMatadero = respuesta.component5();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isVacunado() {
		return vacunado;
	}

	public void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getIdGranjero() {
		return idGanadero;
	}

	public void setIdGanadero(String idGanadero) {
		this.idGanadero = idGanadero;
	}

	public String getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(String idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getIdMatadero() {
		return idMatadero;
	}

	public void setIdMatadero(String idMatadero) {
		this.idMatadero = idMatadero;
	}

	@Override
	public String toString() {
		return "CerdoDTO [id=" + id + ", vacunado=" + vacunado + ", procesado=" + procesado + ", raza=" + raza
				+ ", idGanadero=" + idGanadero + ", idVeterinario=" + idVeterinario + ", idMatadero=" + idMatadero
				+ "]";
	}

}
