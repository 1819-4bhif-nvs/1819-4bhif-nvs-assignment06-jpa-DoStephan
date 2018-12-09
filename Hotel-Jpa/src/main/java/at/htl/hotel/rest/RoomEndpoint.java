package at.htl.hotel.rest;


import at.htl.hotel.model.Hotel;
import at.htl.hotel.model.Room;

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

@Path("room")
@Stateless
public class RoomEndpoint {
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Room> query = em.createNamedQuery("Room.getAll", Room.class);
        List<Room> employees = query.getResultList();
        return Response.ok().entity(employees).build();
    }
    @GET
    @Path("bedamount")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByBEdAmount(){
        TypedQuery<Room> query = em.createNamedQuery("Room.getAllByBedAmount", Room.class)
                .setParameter("AMOUNT",2);
        List<Room> employees = query.getResultList();
        return Response.ok().entity(employees).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Room room = em.find(Room.class,id);
        return Response.ok().entity(room).build();
    }
}
