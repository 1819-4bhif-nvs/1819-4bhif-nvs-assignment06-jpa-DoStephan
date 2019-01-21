package at.htl.hotel.model;

import javax.persistence.*;
import javax.ws.rs.Path;
import java.util.List;

@Entity
public class Employee extends Person {

    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private int salary;
    private String worktype;

    @ManyToOne
    private Hotel hotel;


    public Employee() {
    }

    public Employee(String name, int age, int salary, String worktype) {
        super(name, age);
        this.salary = salary;
        this.worktype = worktype;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorktype() {
        return worktype;
    }

    public void setWorktype(String worktype) {
        this.worktype = worktype;
    }

}
