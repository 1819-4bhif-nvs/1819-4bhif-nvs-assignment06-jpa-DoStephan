package at.htl.hotel.rest;

import at.htl.hotel.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("")
@Stateless
public class StartEndpoint {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Hallo!" ;
    }
}
