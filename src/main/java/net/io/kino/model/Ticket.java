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

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private ShowTime showTime;

    @OneToOne
    @JoinColumn
    @JsonIdentityReference(alwaysAsId = true)
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Ticket() {
    }


    public Ticket(Seat seat, ShowTime showTime, TicketType ticketType, Order order) {
        this.seat = seat;
        this.showTime = showTime;
        this.ticketType = ticketType;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
