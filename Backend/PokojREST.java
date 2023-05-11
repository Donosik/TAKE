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

@Path("/Akademiki/Pokoj")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class PokojREST {
	
	@EJB
	PokojEJB bean;
	
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
	public Response create(Pokoj pokoj)
	{
		bean.create(pokoj);
		return Response.ok().build();
	}
	
	@PUT
	public Response update(Pokoj pokoj)
	{
		bean.update(pokoj);
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
	
	// Endpointy do obs³ugi listy studentów
	
	@GET
    @Path("/{id}/Studenci")
    public Response getStudenci(@PathParam("id") int id) 
	{
        Pokoj pokoj = bean.get(id);
        if(pokoj==null)
        	return Response.status(404).build();
        List<Student> list = pokoj.getStudenci();
        if(list.size()==0)
        	return Response.status(204).build();
        else
        	return Response.ok(list).build();
    }

    @POST
    @Path("/{id}/Student")
    public Response addStudent(@PathParam("id") int id, Student student) 
    {
        if(bean.addObject(id, student))
        	return Response.ok().build();
        else
        	return Response.status(404).build();
    }

    @PUT
    @Path("/{id}/Student/{studentId}")
    public Response updateStudentInPokoj(@PathParam("id") int id, @PathParam("studentId") int studentId)
    {
    	if(bean.addObject(id, studentId))
    		return Response.ok().build();
    	else
    		return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}/Student/{studentId}")
    public Response deleteStudentFromPokoj(@PathParam("id") int id, @PathParam("studentId") int studentId) 
    {
        if(bean.removeObject(id,studentId))
        	return Response.ok().build();
        else
        	return Response.status(404).build();
    }
}
