package net.io.kino.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Comparable<Order> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    @Embedded
    private PersonalDetails client;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    private LocalDateTime date;
    private String transactionId;


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

    public Order(List<Ticket> tickets, PersonalDetails client, OrderState state, LocalDateTime date) {
        this.tickets = tickets;
        this.client = client;
        this.state = state;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getOrderValue()
    {
        double orderValue = 0;
        for (Ticket t : this.getTickets()) {
            orderValue += t.getTicketType().getPrice();
        }
        return  orderValue;
    }

    @Override
    public int compareTo(Order order) {
        return Long.compare(getId(), order.getId());
    }
}
