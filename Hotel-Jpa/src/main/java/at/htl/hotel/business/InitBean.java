package at.htl.hotel.business;

import at.htl.hotel.model.Employee;
import at.htl.hotel.model.Guest;
import at.htl.hotel.model.Hotel;
import at.htl.hotel.model.Room;

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
        initEmployees();
    }

    private void initGuests() {
        Guest g1 = new Guest("Robert E", 29, "29.02.2018",5);
        Guest g2 = new Guest("Jonathan J", 19, "07.12.2018",3);
        Guest g3 = new Guest("Josef J", 52, "07.06.2018",4);
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
            new Room(101, 2, 165),
            new Room(115, 3, 180),
            new Room(201, 2, 120),
            new Room(117, 2, 150),
            new Room(309, 1, 100),
            new Room(215, 2, 145)
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
