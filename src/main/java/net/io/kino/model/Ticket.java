package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private Seat seat;

    private String cokolwiek;

    public Ticket() {}

    public Ticket(Seat seat, String cokolwiek) {
        this.seat = seat;
        this.cokolwiek = cokolwiek;
    }

    public long getId() {
        return id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getCokolwiek() {
        return cokolwiek;
    }

    public void setCokolwiek(String cokolwiek) {
        this.cokolwiek = cokolwiek;
    }

}
