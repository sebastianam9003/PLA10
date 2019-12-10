package com.trifulcas.proyecto.dao;

import java.util.List;
import com.trifulcas.proyecto.model.Paciente;

public interface IPacienteDAO {
	List<Paciente> getPacientes();
	
	void save(Paciente paciente);
	
	Paciente getPaciente(int idpaciente);
	
	void delete(Paciente paciente);
}
