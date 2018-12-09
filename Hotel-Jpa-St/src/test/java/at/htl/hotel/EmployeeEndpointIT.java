package at.htl.hotel;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.StringContains.containsString;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeEndpointIT {
    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/hotel/jpa/emp");
    }
    @Test public void T01fetchEmployee(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        System.out.println("payload = "+payload);
        assertThat(response.getStatus(), is(200));
        JsonObject employee = payload.getJsonObject(0);
        assertThat(employee.getString("name"),is("Maria"));

    }
    @Test public void T02getEmployeeWithId(){
        Response res = this.target.path("read/5").request(MediaType.APPLICATION_JSON).get();
        JsonObject employee = res.readEntity(JsonObject.class);
        assertThat(employee.getString("worktype"), is("Clean staff"));
        assertThat(employee.getInt("salary"), is(900));
        assertThat(employee.getString("name"), is("Alfred"));
    }
    @Test public void T03getAllEmployee(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        assertThat(payload.size(),is(2));
    }

//    @Test public void T03deleteEmployee(){
//        Response response = this.target
//                .request(MediaType.APPLICATION_JSON).delete();
//        assertThat(response.getStatus(), is(204));
//
//    }

}
