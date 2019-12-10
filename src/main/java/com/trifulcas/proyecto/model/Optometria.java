package com.trifulcas.proyecto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "optometria")
public class Optometria {

	@Id
	@Column(name = "idoptometria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idoptometria;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "odeje")
	private int odeje;
	
	@Column(name = "odcilindro")
	private int odcilindro;
	
	@Column(name = "odesfera")
	private int odesfera;
	
	@Column(name = "oieje")
	private int oieje;
	
	@Column(name = "oicilindro")
	private int oicilindro;
	
	@Column(name = "oiesfera")
	private int oiesfera;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="idpaciente")
	private Paciente pacientes;

	//Constructores
	public Optometria() {
		
	}
	public Optometria(int odeje, int odciliendro, int odesfera, int oieje, int oicilindro, int oiesfera) {
		super();
		this.odeje = odeje;
		this.odcilindro = odcilindro;
		this.odesfera = odesfera;
		
		this.oieje = oieje;
		this.oicilindro = oicilindro;
		this.oiesfera = oiesfera;
	}
	
	//getter and setter
	public Paciente getPacientes() {
		return pacientes;
	}
	
	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}
	
	public int getIdoptometria() {
		return idoptometria;
	}

	public void setIdoptometria(int idoptometria) {
		this.idoptometria = idoptometria;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getOdeje() {
		return odeje;
	}

	public void setOdeje(int odeje) {
		this.odeje = odeje;
	}

	public int getOdcilindro() {
		return odcilindro;
	}

	public void setOdcilindro(int odcilindro) {
		this.odcilindro = odcilindro;
	}

	public int getOdesfera() {
		return odesfera;
	}

	public void setOdesfera(int odesfera) {
		this.odesfera = odesfera;
	}

	public int getOieje() {
		return oieje;
	}

	public void setOieje(int oieje) {
		this.oieje = oieje;
	}

	public int getOicilindro() {
		return oicilindro;
	}

	public void setOicilindro(int oicilindro) {
		this.oicilindro = oicilindro;
	}

	public int getOiesfera() {
		return oiesfera;
	}

	public void setOiesfera(int oiesfera) {
		this.oiesfera = oiesfera;
	}
	
	
	
	
}
