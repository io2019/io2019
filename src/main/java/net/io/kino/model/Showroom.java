package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Showroom(String name, int numberOfSeats) {
        this.name = name;
        this.noOfSeats = numberOfSeats;

        for (int i = 0; i <numberOfSeats ; i++) {
            this.seats.add(new Seat(i));
        }
    }

    public Showroom() {}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    private String name;
    private Integer noOfSeats;

    @OneToMany
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private List<Seat> seats;


}
