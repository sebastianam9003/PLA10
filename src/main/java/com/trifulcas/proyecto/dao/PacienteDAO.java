package com.trifulcas.proyecto.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.proyecto.model.Paciente;

@Repository
public class PacienteDAO implements IPacienteDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Paciente> getPacientes() {
		Session miSesion = sessionFactory.getCurrentSession();
		
		List<Paciente> pacientes = miSesion.createQuery("from Paciente", Paciente.class).list();
		return pacientes;
	}
	
	
	public void save(Paciente paciente) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(paciente);
	}
	
	
	public Paciente getPaciente(int idpaciente) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Paciente.class,idpaciente);
	}
	
	
	public void delete(Paciente paciente) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(paciente);

	}
}
