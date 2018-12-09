package at.htl.hotel.model;

import javax.persistence.*;
@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.getAll", query = "select e from Person e where e.dType like 'Employee'"),
        @NamedQuery(name = "Guest.getAll", query = "select g from Person g where g.dType like 'Guest'")

})

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Column(name = "DTYPE", insertable = false, updatable = false)
    private String dType;

    @ManyToOne
    private Hotel hotel;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
