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
    private ShowTime showTime;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private TicketType ticketType;

    private Integer seatPosition;

    public Ticket() {
    }

    public Ticket(Integer seatPosition, ShowTime showTime, TicketType ticketType) {
        this.seatPosition = seatPosition;
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

    public Integer getSeatPosition() {
        return seatPosition;
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

    public void setSeatPosition(Integer seatPosition) {
        this.seatPosition = seatPosition;
    }
}
