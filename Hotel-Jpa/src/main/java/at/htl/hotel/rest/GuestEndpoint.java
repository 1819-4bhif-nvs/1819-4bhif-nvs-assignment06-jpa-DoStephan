package at.htl.hotel.rest;

import at.htl.hotel.model.Guest;
import at.htl.hotel.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("guest")
@Stateless
public class GuestEndpoint {

    @PersistenceContext
    EntityManager em;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Person> query = em.createNamedQuery("Guest.getAll",Person.class);
        List<Person> guests = query.getResultList();
        return Response.ok().entity(guests).build();
    }
    
    //CREATE
    @POST
    public void post(Guest guest){
        em.persist(guest);
        System.out.println(guest.getName() + "wurde gespeichert");
    }
    //READ
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("read/{id}")
    public Response get(@PathParam("id") Long id) {
        Guest guest = em.find(Guest.class,id);
        return Response.ok().entity(guest).build();
    }
    //UPDATE
    @GET
    @Path("update/{id}")
    public void update(@PathParam("id") Long id) {
        Guest guest = em.find(Guest.class,id);

        em.merge(guest);
        System.out.println(guest.getName() + "wurde verändert");
    }

    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") long id){
        Guest guest = em.find(Guest.class,id);
        em.remove(guest);
        System.out.println(guest.getName() + "wurde gelöscht");
    }
}
