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
    private Showtime showtime;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private TicketType ticketType;

    private Integer seatPosition;

    public Ticket() {
    }

    public Ticket(Integer seatPosition, Showtime showtime, TicketType ticketType) {
        this.seatPosition = seatPosition;
        this.showtime = showtime;
        this.ticketType = ticketType;
    }

    public long getId() {
        return id;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Integer getSeatPosition() {
        return seatPosition;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setSeatPosition(Integer seatPosition) {
        this.seatPosition = seatPosition;
    }
}
