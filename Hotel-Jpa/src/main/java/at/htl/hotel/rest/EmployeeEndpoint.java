package at.htl.hotel.rest;

import at.htl.hotel.model.Employee;
import at.htl.hotel.model.Guest;
import at.htl.hotel.model.Hotel;
import at.htl.hotel.model.Person;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("emp")
@Stateless
public class EmployeeEndpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        TypedQuery<Person> query = em.createNamedQuery("Employee.getAll",Person.class);
        List<Person> employees = query.getResultList();

        //post(new Employee("Hans", 44, 1200,"Kellner"));
        //update(6);
        //delete(6);
        return Response.ok().entity(employees).build();
    }
    //CREATE
    @POST
    public void post(Employee emp){
        em.persist(emp);
        System.out.println(emp.getName() + "wurde gespeichert");
    }
    //READ
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("read/{id}")
    public Response get(@PathParam("id") Long id) {
        Employee emp = em.find(Employee.class,id);
        return Response.ok().entity(emp).build();
    }
    //UPDATE
    @GET
    @Path("update/{id}")
    public void update(@PathParam("id") Long id) {
        Employee emp = em.find(Employee.class,id);
        emp.setSalary(2000);
        em.merge(emp);
        System.out.println(emp.getName() + "wurde verändert");
    }

    @DELETE
    @Path("delete/{id}")
    public void delete(@PathParam("id") long id){
        Employee emp = em.find(Employee.class,id);
        em.remove(emp);
        System.out.println(emp.getName() + "wurde gelöscht");
    }
}
