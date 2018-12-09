package at.htl.hotel.rest;

import at.htl.hotel.model.Employee;
import at.htl.hotel.model.Hotel;
import at.htl.hotel.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("hotel")
@Stateless
public class HotelEndpoint {
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Hotel> query = em.createNamedQuery("Hotel.getAll", Hotel.class);
        List<Hotel> employees = query.getResultList();
        return Response.ok().entity(employees).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Hotel hotel = em.find(Hotel.class,id);
        return Response.ok().entity(hotel).build();
    }
}
