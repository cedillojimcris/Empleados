package com.mx.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mx.entity.Employees;
import com.mx.general.Metodos;

public class EmployeesDao implements Metodos {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Empleado");
	EntityManager em = emf.createEntityManager();
	
	Employees employees;
	
	@Override
	public String guardar(Object obj) {
		employees = (Employees) obj;
		em.getTransaction().begin();
		String p = null;
		try 
		{
			em.persist(employees);
			em.getTransaction().commit();
			System.out.println("Se incertó -->"+employees);
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
		employees = (Employees) obj;
		employees= em.find(Employees.class, employees.getId());
		return employees;
	}
	@Override
	public List listar() {
		
		return em.createQuery("from Employees order by id").getResultList();
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
