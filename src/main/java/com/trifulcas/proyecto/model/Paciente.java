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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@Column(name = "idpaciente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpaciente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "paciente", cascade = { CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	private List<Optometria> optometrias;
	
	public void addOptometria(Optometria revisiones) {
		if(optometrias== null) {
			                    optometrias= new ArrayList<Optometria>();
			                  }
		optometrias.add(revisiones);
		revisiones.setPacientes(this);
		}
	
	//Constructores
	public Paciente() {
		
	}
	
	public Paciente(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	//getter and setter
	public List<Optometria> getOptometrias() {
		return optometrias;
	}
	
	public void setOptometrias(List<Optometria> optometrias) {
		this.optometrias= optometrias;
	}
	
	public int getIdpaciente() {
		return idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
