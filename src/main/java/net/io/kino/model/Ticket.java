package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;

@Embeddable
public class Ticket {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private Seat seat;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private ShowTime showTime;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private TicketType ticketType;

    public Ticket() {
    }

    public Ticket(Seat seat, ShowTime showTime, TicketType ticketType) {
        this.seat = seat;
        this.showTime = showTime;
        this.ticketType = ticketType;
    }

    public long getId() {
        return id;
    }

    public ShowTime getShowTime() {
        return showTime;
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

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
