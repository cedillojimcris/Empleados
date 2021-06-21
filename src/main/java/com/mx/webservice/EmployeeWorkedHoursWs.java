package com.mx.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mx.dao.EmployeeWorkedHoursDao;
import com.mx.entity.EmployeeWorkedHours;
import com.mx.general.EstatusRespuestas;

@Path("HoursWs")
public class EmployeeWorkedHoursWs {
	
	
	 EmployeeWorkedHoursDao dao = null;
	 
	 @Path("listar")
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public List<EmployeeWorkedHours> listar()
		{
			dao = new EmployeeWorkedHoursDao();
			List<EmployeeWorkedHours> lista = dao.listar();
			System.out.println("lista --> "+lista);
			return lista;
		}
		
		@POST
		@Path("guardar")
		@Consumes({ MediaType.APPLICATION_JSON})
		@Produces({ MediaType.APPLICATION_JSON})
		public EstatusRespuestas guardar(EmployeeWorkedHours hours)
		{
			EstatusRespuestas er = new EstatusRespuestas();
			dao = new EmployeeWorkedHoursDao();
			String r  = dao.guardar(hours);
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
