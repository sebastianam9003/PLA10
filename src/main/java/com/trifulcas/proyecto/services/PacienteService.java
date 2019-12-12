package com.trifulcas.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trifulcas.proyecto.dao.IPacienteDAO;
import com.trifulcas.proyecto.model.Paciente;

@Service("pacienteService")
public class PacienteService implements IPacienteService {

	@Autowired
	private IPacienteDAO pacienteDAO;
	
	
	@Transactional
	public List<Paciente> getPacientes() {
		return pacienteDAO.getPacientes();
	}
	
	@Transactional
	public void save(Paciente paciente) {
		pacienteDAO.save(paciente);

	}

	
	@Transactional
	public Paciente getPaciente(int idpaciente) {
		
		return pacienteDAO.getPaciente(idpaciente);
	}

	
	@Transactional
	public void delete(Paciente paciente) {
		pacienteDAO.delete(paciente);

	}
	
}
