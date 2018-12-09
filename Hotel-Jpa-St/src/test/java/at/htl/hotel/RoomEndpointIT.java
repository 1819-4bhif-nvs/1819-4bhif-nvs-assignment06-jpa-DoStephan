package at.htl.hotel;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomEndpointIT {
    private Client client;
    private WebTarget target;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/hotel/jpa/room");
    }
    @Test public void T01fetchRoom(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        System.out.println("payload = "+payload);

        JsonObject room = payload.getJsonObject(4);
        assertThat(room.getInt("id"),is(5));

    }
    @Test public void T02getRoomWithId() {
        Response res = this.target.path("3").request(MediaType.APPLICATION_JSON).get();
        JsonObject room = res.readEntity(JsonObject.class);
        assertThat(room.getInt("bedAmount"), is(2));
        assertThat(room.getInt("price"), is(120));
        assertThat(room.getInt("roomNr"), is(201));
    }
    @Test public void T03deleteRoom(){
        Response response = this.target.request(MediaType.APPLICATION_JSON).get();
        JsonArray payload = response.readEntity(JsonArray.class);
        assertThat(payload.size(),is(6));
    }
//    @Test
//    public void T04createVehicleJsonObj(){
//        JsonObjectBuilder jsBuild = Json.createObjectBuilder();
//
//        JsonObject room = jsBuild
//                .add("bedAmount","5")
//                .add("price","199")
//                .add("roomNr","132")
//                .build();
//
//        assertThat(room.getString("price") ,is("199"));
//        Response res = this.target
//                .request(MediaType.APPLICATION_JSON)
//                .post(Entity.json(room));
//        assertThat(res.getStatus(),is(201));
//    }
}
