package com.mx.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.JobsDao;
import com.mx.entity.Jobs;
import com.mx.general.EstatusRespuestas;

@Path("JobsWs")
public class JobsWs {
	
	JobsDao dao = null;
	
	@GET
	@Path("listar")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Jobs> listar()
	{
		dao = new JobsDao();
		List<Jobs> lista = dao.listar();
		System.out.println("lista --> "+lista);
		return lista;
	}
	
	@POST
	@Path("guardar")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public EstatusRespuestas guardar(Jobs jobs)
	{
		EstatusRespuestas er = new EstatusRespuestas();
		dao = new JobsDao();
		String r  = dao.guardar(jobs);
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
	
	
	@POST
	@Path("buscar")
	@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public Jobs buscar(Jobs jobs)
	{
		dao = new JobsDao();
		jobs = (Jobs) dao.buscar(jobs);
		return jobs;
	}
	
}
