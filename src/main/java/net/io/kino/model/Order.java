package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Order implements Comparable<Order> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection
    @CollectionTable(
            name = "TICKET",
            joinColumns = @JoinColumn(name = "ORDER_ID")
    )
    private List<Ticket> tickets;
    @Embedded
    private PersonalDetails client;
    @Enumerated(EnumType.STRING)
    private OrderState state;
    private LocalDateTime date;


    public Order() {
    }

    public Order(String email) {
        this.client = new PersonalDetails(email);
    }


    public Order(List<Ticket> tickets, PersonalDetails client, OrderState state) {
        this.tickets = tickets;
        this.client = client;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public PersonalDetails getClient() {
        return client;
    }

    public void setClient(PersonalDetails client) {
        this.client = client;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public int compareTo(Order order) {
        return Long.compare(getId(), order.getId());
    }
}
