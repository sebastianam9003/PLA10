package com.trifulcas.proyecto.dao;

import java.util.List;
import com.trifulcas.proyecto.model.Optometria;

public interface IOptometriaDAO {
	List<Optometria> getOptometrias();
	
	List<Optometria> getOptometrias(int idpaciente);
	
	void save(Optometria optometria);
	
	Optometria getOptometria(int idoptometria);
	
	void delete(Optometria optometria);
}
