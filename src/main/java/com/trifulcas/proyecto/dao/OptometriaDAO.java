package com.trifulcas.proyecto.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.proyecto.model.Optometria;

@Repository
public class OptometriaDAO implements IOptometriaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Optometria> getOptometrias() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Optometria> optometrias=miSesion.createQuery("from Optometria", Optometria.class).list();
		return optometrias;
	}
	
	public List<Optometria> getOptometrias(int idpaciente) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Optometria> optometrias=miSesion.createQuery("from Optometriat where idpaciente=:idpaciente", 
				Optometria.class).setParameter("idpaciente", idpaciente).list();
		return optometrias;
	}
	
	public void save(Optometria optometria) {
		Session miSesion = sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(optometria);

	}
	
	public Optometria getOptometria(int idoptometria) {
		Session miSesion = sessionFactory.getCurrentSession();
		return miSesion.get(Optometria.class,idoptometria);
	}
	
	public void delete(Optometria optometria) {
		Session miSesion = sessionFactory.getCurrentSession();
		miSesion.delete(optometria);
	}

}
