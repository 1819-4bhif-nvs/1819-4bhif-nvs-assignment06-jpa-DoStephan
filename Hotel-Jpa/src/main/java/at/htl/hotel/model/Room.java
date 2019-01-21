package at.htl.hotel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Room.getAll", query = "select r from Room r"),
        @NamedQuery(name = "Room.getAllByBedAmount",query = "select r from Room r where r.bedAmount = :AMOUNT")
})
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long id;
    private int roomNr;
    private int bedAmount;
    private double price;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Transient
    private List<Booking> bookings;

    public Room() {
    }

    public Room(int roomNr, int bedAmount, double price, Hotel hotel) {
        this.roomNr = roomNr;
        this.bedAmount = bedAmount;
        this.price = price;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
