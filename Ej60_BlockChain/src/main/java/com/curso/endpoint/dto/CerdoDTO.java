package com.curso.endpoint.dto;

/*
struct Cerdo {
  uint id;
  bool vacunado;
  bool vendido;
  string raza;
  uint granjeroId;
  uint veterinarioId;
  uint mataderoId;
}
*/

public class CerdoDTO {

	private Integer id;
	private boolean vacunado;
	private boolean procesado;
	private String raza;
	private Integer idGranjero;
	private Integer idVeterinario;
	private Integer idMatadero;

	public CerdoDTO() {
		super();
	}

	public CerdoDTO(Integer id, boolean vacunado, boolean procesado, String raza, Integer idGranjero,
			Integer idVeterinario, Integer idMatadero) {
		super();
		this.id = id;
		this.vacunado = vacunado;
		this.procesado = procesado;
		this.raza = raza;
		this.idGranjero = idGranjero;
		this.idVeterinario = idVeterinario;
		this.idMatadero = idMatadero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getIdGranjero() {
		return idGranjero;
	}

	public void setIdGranjero(Integer idGranjero) {
		this.idGranjero = idGranjero;
	}

	public Integer getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(Integer idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public Integer getIdMatadero() {
		return idMatadero;
	}

	public void setIdMatadero(Integer idMatadero) {
		this.idMatadero = idMatadero;
	}

	@Override
	public String toString() {
		return "Cerdo [id=" + id + ", vacunado=" + vacunado + ", procesado=" + procesado + ", raza=" + raza
				+ ", idGranjero=" + idGranjero + ", idVeterinario=" + idVeterinario + ", idMatadero=" + idMatadero
				+ "]";
	}

}
