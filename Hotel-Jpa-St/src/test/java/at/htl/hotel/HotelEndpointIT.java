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
public class HotelEndpointIT {
    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/hotel/jpa/hotel");
    }
    @Test public void T01fetchHotel(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        System.out.println("payload = "+payload);
        assertThat(response.getStatus(), is(200));
        JsonObject hotel = payload.getJsonObject(0);
        assertThat(hotel.getString("name"),is("Dom Hotel"));

    }
    @Test public void T02getHotelWithId(){
        Response res = this.target.path("2").request(MediaType.APPLICATION_JSON).get();
        JsonObject hotel = res.readEntity(JsonObject.class);
        assertThat(hotel.getString("location"), is("Paris"));
    }
//    @Test public void T03deleteHotel(){
//        Response response = this.target
//                .request(MediaType.APPLICATION_JSON).delete();
//        assertThat(response.getStatus(), is(204));
//
//    }

}
