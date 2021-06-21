package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entity.Genders;
import com.mx.general.Metodos;

public class GendersDao implements Metodos {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Genero");
	EntityManager em = emf.createEntityManager();

	Genders genders;
	
	@Override
	public String guardar(Object obj) {
		genders = (Genders) obj;
		em.getTransaction().commit();
		String p = null;
		try
		{
			em.persist("genders");
			em.getTransaction().commit();
			System.out.println("Se agrego --> "+genders);
			p = "1";
		}
		catch(Exception e)
		{
			em.getTransaction().rollback();
			System.out.println("false");
			p = e.getMessage();
		}
		return p;
	}

	@Override
	public Object buscar(Object obj) {
		genders = (Genders) obj;
		genders = em.find(Genders.class, genders.getId());
		return genders;
	}

	@Override
	public List listar() {
		return em.createQuery("from Genders order by id").getResultList();
	}

	@Override
	public String editar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}



}

