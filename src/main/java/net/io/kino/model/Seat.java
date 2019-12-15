package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int numerek;

    public Seat() {
    }

    public Seat(int numerek) {
        this.numerek = numerek;
    }

    public long getId() {
        return id;
    }

    public int getNumerek() {
        return numerek;
    }

}
