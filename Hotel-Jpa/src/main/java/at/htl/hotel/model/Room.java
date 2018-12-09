package at.htl.hotel.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Room.getAll", query = "select r from Room r"),
        @NamedQuery(name = "Room.getAllByBedAmount",query = "select r from Room r where r.bedAmount = :AMOUNT")
})
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNr;
    private int bedAmount;
    private double price;

    @ManyToOne
    private Hotel hotel;

    public Room() {
    }

    public Room(int roomNr, int bedAmount, double price) {
        this.roomNr = roomNr;
        this.bedAmount = bedAmount;
        this.price = price;
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

}
