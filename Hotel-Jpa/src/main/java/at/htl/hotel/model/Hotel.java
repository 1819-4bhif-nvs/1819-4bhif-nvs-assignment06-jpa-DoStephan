package at.htl.hotel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Hotel.getAll", query = "select h from Hotel h")

public class Hotel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double rating;
    private int star;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Transient
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)

    private List<Employee> employees;

    //region Construct
    public Hotel() {
    }

    public Hotel(String name, String location, double rating, int star) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.star = star;
    }
    //endregion
    //export JAVA_HOME/jdk
    //ln -s /path/ postman
    //swagger openapi
    //openapi gui
    //region Getter Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    //endregion
}
