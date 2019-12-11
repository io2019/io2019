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
    private Show show;
    private TicketType ticketType;
    private Seat seat;

    public Ticket() {
    }

    public Ticket(Show show, TicketType ticketType, Seat seat) {
        this.show = show;
        this.ticketType = ticketType;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
