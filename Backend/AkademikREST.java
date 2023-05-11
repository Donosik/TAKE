package pl.take.akademiki;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/Akademiki/Akademik")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class AkademikREST {

	@EJB
	AkademikEJB bean;
	
	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id)
	{
		if(bean.get(id)==null)
			return Response.status(404).build();
		else
			return Response.ok(bean.get(id)).build();
	} 
	
	@GET
	public Response getAll()
	{
		if(bean.getAll().size()==0)
			return Response.status(204).build();
		else
			return Response.ok(bean.getAll()).build();
	}
	
	@POST
	public Response create(Akademik akademik)
	{
		bean.create(akademik);
		return Response.ok().build();
	}
	
	@PUT
	public Response update(Akademik akademik)
	{
		bean.update(akademik);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id)
	{
		if(bean.delete(id))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
	// Endpointy do obs³ugi listy pokoi
	
	@GET
	@Path("/{id}/Pokoje")
	public Response getPokoje(@PathParam("id")int id)
	{
		Akademik akademik=bean.get(id);
		if(akademik==null)
			return Response.status(404).build();
		List<Pokoj> list=akademik.getPokoje();
		if(list.size()==0)
			return Response.status(204).build();
		else
			return Response.ok(list).build();
	}
	
	@POST
	@Path("/{id}/Pokoj")
	public Response addPokoj(@PathParam("id") int id,Pokoj pokoj)
	{
		if(bean.addObject(id, pokoj))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
	@PUT
	@Path("/{id}/Pokoj/{pokojId}")
	public Response updatePokojToAkademik(@PathParam("id") int id,@PathParam("pokojId") int pokojId)
	{
		if(bean.addObject(id, pokojId))
			return Response.ok().build();
		else
			return Response.status(404).build();
	}
	
	@DELETE
	@Path("/{id}/Pokoj/{pokojId}")
	public Response deletePokojFromAkademik(@PathParam("id") int id,@PathParam("pokojId") int pokojId)
	{
		if(bean.removeObject(id, pokojId))
			return Response.ok().build();
		else
			return Response.status(404).build();
		
	}
}
