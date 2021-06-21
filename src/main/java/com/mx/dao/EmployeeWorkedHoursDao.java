package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entity.EmployeeWorkedHours;
import com.mx.general.Metodos;

public class EmployeeWorkedHoursDao implements Metodos {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("horas");
	EntityManager em = emf.createEntityManager();
	
	EmployeeWorkedHours employeeH;

	@Override
	public String guardar(Object obj) {
		employeeH = (EmployeeWorkedHours) obj;
		em.getTransaction().begin();
		String p = null;
		
		try 
		{
			em.persist(employeeH);
			em.getTransaction().commit();
			System.out.println("Agregado correctamente "+employeeH);
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
		employeeH = (EmployeeWorkedHours) obj;
		employeeH = em.find(EmployeeWorkedHours.class, employeeH.getId());
		return employeeH;
	}

	@Override
	public List listar() {
		return em.createQuery("from EmployeeWorkedHours order by id").getResultList();
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

