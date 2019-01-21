package at.htl.hotel.business;

import at.htl.hotel.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class InitBean {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){

        initHotels();
        initRooms();
        initGuests();
        initBookings();
        initEmployees();
    }

    private void initBookings() {
        Booking b1 = new Booking("29.02.2018",5,
                em.find(Guest.class,2L), em.find(Room.class,3L));
        Booking b2 = new Booking("07.12.2018",3,
                em.find(Guest.class,1L), em.find(Room.class,1L));
        Booking b3 = new Booking("07.06.2018",4,
                em.find(Guest.class,3L), em.find(Room.class,0L));

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
    }

    private void initGuests() {
        Guest g1 = new Guest("Robert E", 29);
        Guest g2 = new Guest("Jonathan J", 19);
        Guest g3 = new Guest("Josef J", 52);
        em.persist(g1);
        em.persist(g2);
        em.persist(g3);
    }

    private void initEmployees() {
        Employee e1 = new Employee("Maria", 32, 1400, "Cook");
        Employee e2 = new Employee("Alfred", 24, 900, "Clean staff");
        em.persist(e1);
        em.persist(e2);
    }

    private void initRooms() {
        Room[] roomArray = {
            new Room(101, 2, 165, em.find(Hotel.class, 1L)),
            new Room(115, 3, 180, em.find(Hotel.class, 1L)),
            new Room(201, 2, 120, em.find(Hotel.class, 3L)),
            new Room(117, 2, 150, em.find(Hotel.class, 1L)),
            new Room(309, 1, 100, em.find(Hotel.class, 2L)),
            new Room(215, 2, 145, em.find(Hotel.class, 3L))
        };

        for (Room r : roomArray){
            em.persist(r);
        }
        
    }

    private void initHotels() {

        Hotel hotelLinz = new Hotel("Dom Hotel", "Linz", 7.9, 4);
        Hotel hotelParis = new Hotel("Hotel Lorette", "Paris", 8.8, 3);
        Hotel hotelWien = new Hotel("Hotel Caroline", "Wien", 8.8, 3);
        em.persist(hotelLinz);
        em.persist(hotelParis);
        em.persist(hotelWien);
    }
}
