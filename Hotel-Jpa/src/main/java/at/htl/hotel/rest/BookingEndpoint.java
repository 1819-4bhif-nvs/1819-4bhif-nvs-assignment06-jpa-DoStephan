package at.htl.hotel.rest;

import at.htl.hotel.model.Booking;
import at.htl.hotel.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("books")
@Stateless
public class BookingEndpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Booking> query = em.createNamedQuery("Booking.getAll",Booking.class);
        List<Booking> bookings = query.getResultList();

        return Response.ok().entity(bookings).build();
    }
}
