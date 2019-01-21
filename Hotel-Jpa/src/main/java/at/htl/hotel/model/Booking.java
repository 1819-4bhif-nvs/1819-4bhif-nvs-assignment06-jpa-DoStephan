package at.htl.hotel.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




@Entity
//@Table(name = "BOOKING")
//@AssociationOverrides({
//        @AssociationOverride(name = "guest",
//            joinColumns = @JoinColumn(name = "PERSON_ID")),
//        @AssociationOverride(name = "room",
//            joinColumns = @JoinColumn(name = "ROOM_ID"))}
//)
@NamedQueries({
        @NamedQuery(name = "Booking.getAll", query = "select b from Booking b")
})
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkInDate;
    private int stayspan;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Room room;

    public Booking(String checkInDate, int stayspan,Guest guest, Room room) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.checkInDate = LocalDate.parse(checkInDate,pattern);
        this.stayspan = stayspan;
        this.guest = guest;
        this.room = room;
    }

    public Booking() {
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getStayspan() {
        return stayspan;
    }

    public void setStayspan(int stayspan) {
        this.stayspan = stayspan;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getId() {
        return id;
    }

}
