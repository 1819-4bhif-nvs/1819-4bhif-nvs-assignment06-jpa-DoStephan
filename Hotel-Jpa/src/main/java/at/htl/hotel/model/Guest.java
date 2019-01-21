package at.htl.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "GUEST")
public class Guest extends Person {

    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;


    @OneToMany (mappedBy = "guest", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Transient
    private List<Booking> bookings;


    public Guest() {
    }

    public Guest(String name, int age) {
        super(name, age);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
