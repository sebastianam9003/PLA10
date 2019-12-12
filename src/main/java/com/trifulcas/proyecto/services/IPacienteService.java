package com.trifulcas.proyecto.services;

import java.util.List;

import com.trifulcas.proyecto.model.Paciente;;

public interface IPacienteService {
	List<Paciente> getPacientes();

	void save(Paciente paciente);

	Paciente getPaciente(int idpaciente);

	void delete(Paciente paciente);
}
