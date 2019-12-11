package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private String name;
    private double Price;
    private TicketState state;

    public TicketType(String name, double price, TicketState state) {
        this.name = name;
        Price = price;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return Price;
    }

    public TicketState getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
