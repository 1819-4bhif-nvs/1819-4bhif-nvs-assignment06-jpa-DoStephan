package at.htl.hotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Guest extends Person {

    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private LocalDate checkInDate;
    private int stayspan;


    public Guest() {
    }

    public Guest(String name, int age, String checkInDate, int stayspan) {
        super(name, age);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        this.checkInDate = LocalDate.parse(checkInDate,pattern);
        this.stayspan = stayspan;
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
}
