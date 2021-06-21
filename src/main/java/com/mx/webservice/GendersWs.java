package com.mx.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.GendersDao;
import com.mx.entity.Genders;


@Path("GendersWs")
public class GendersWs {
	
	GendersDao dao = null;
	
	@GET
	@Path("listar")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Genders> listar()
	{
		dao = new GendersDao();
		List<Genders> lista = dao.listar();
		System.out.println("lista --> "+lista);
		return lista;
	}

}
