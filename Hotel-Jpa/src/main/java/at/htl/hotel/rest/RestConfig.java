package at.htl.hotel.rest;

import at.htl.hotel.model.Hotel;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class RestConfig extends Application {
    @Override

    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new HashSet<>();

        classes.add(HotelEndpoint.class);
        classes.add(BookingEndpoint.class);
        classes.add(EmployeeEndpoint.class);
        classes.add(GuestEndpoint.class);
        classes.add(RoomEndpoint.class);

        classes.add(com.github.phillipkruger.apiee.ApieeService.class);

        return classes;

    }
}
