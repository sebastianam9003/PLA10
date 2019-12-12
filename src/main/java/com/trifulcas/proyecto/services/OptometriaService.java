package com.trifulcas.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trifulcas.proyecto.dao.IOptometriaDAO;
import com.trifulcas.proyecto.model.Optometria;

@Service("optometriaService")
public class OptometriaService implements IOptometriaService {

	@Autowired
	private IOptometriaDAO optometriaDAO;
	
	
	@Transactional
	public List<Optometria> getOptometrias() {
		return optometriaDAO.getOptometrias();
	}
	
	@Transactional
	public void save(Optometria optometria) {
		optometriaDAO.save(optometria);

	}
	
	@Transactional
	public Optometria getOptometria(int idoptometria) {
		
		return optometriaDAO.getOptometria(idoptometria);
	}
	
	@Transactional
	public void delete(Optometria optometria) {
		optometriaDAO.delete(optometria);
	}
	
	@Transactional
	public List<Optometria> getOptometrias(int idpaciente) {
		return optometriaDAO.getOptometrias(idpaciente);
	}
}
