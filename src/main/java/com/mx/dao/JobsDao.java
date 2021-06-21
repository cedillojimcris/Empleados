package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entity.Jobs;
import com.mx.general.Metodos;

public class JobsDao implements Metodos {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabajo");
	EntityManager em = emf.createEntityManager();
	
	Jobs jobs;

	@Override
	public String guardar(Object obj) {
		jobs = (Jobs) obj;
		em.getTransaction().commit();
		String p = null;
		try
		{
			em.persist(jobs);
			em.getTransaction().commit();
			System.out.println("Se incertó correctamente -->"+jobs);
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
		jobs = (Jobs) obj;
		jobs = em.find(Jobs.class, jobs.getName());
		return jobs;
	}

	@Override
	public List listar() {
		
		return em.createQuery("from Jobs order by id").getResultList();
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
