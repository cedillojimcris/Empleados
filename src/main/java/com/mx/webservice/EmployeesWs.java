package com.mx.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.EmployeesDao;

import com.mx.entity.Employees;

import com.mx.general.EstatusRespuestas;


@Path("EmployeesWs")
public class EmployeesWs {
	
	EmployeesDao dao = null;
	
	@GET
	@Path("listar")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Employees> listar()
	{
		dao = new EmployeesDao();
		List<Employees> lista = dao.listar();
		System.out.println("lista --> "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public EstatusRespuestas guardar(Employees employees)
	{
		EstatusRespuestas er = new EstatusRespuestas();
		dao = new EmployeesDao();
		String r  = dao.guardar(employees);
		if(r.equals("!"))
		{
			er.setMensaje("Guardado");
			er.setResp(r);
		}
		else
		{
			er.setMensaje("Error");
			er.setResp(r);
		}
		
		return er;
	}

}
