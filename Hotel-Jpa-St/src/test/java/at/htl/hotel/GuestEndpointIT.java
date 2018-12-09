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
public class GuestEndpointIT {
    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/hotel/jpa/guest");
    }
    @Test public void T01fetchGuest(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        System.out.println("payload = "+payload);
        assertThat(response.getStatus(), is(200));
        JsonObject guest = payload.getJsonObject(0);
        assertThat(guest.getString("name"),is("Robert E"));

    }
    @Test public void T02getGuestWithId(){
        Response res = this.target.path("read/1").request(MediaType.APPLICATION_JSON).get();
        JsonObject guest = res.readEntity(JsonObject.class);
        assertThat(guest.getInt("age"), is(29));
        assertThat(guest.getInt("stayspan"), is(5));
        assertThat(guest.getString("checkInDate"), is("2018-02-28"));
    }
    @Test public void T03getAllGuest(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        assertThat(payload.size(),is(3));
    }

//    @Test public void T03deleteGuest(){
//        Response response = this.target
//                .request(MediaType.APPLICATION_JSON).delete();
//        assertThat(response.getStatus(), is(204));
//
//    }

}
