package com.trifulcas.proyecto.services;

import java.util.List;

import com.trifulcas.proyecto.model.Optometria;

public interface IOptometriaService {
	List<Optometria> getOptometrias();
	
	List<Optometria> getOptometrias(int idpaciente);
	
	void save(Optometria optometria);
	
	Optometria getOptometria(int idoptometria);
	
	void delete(Optometria optometria);
}
