package net.io.kino.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Order implements Comparable<Order>
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<Ticket> tickets;
    private PersonalDetails client;
    private OrderState state;

    public Order(List<Ticket> tickets, PersonalDetails client, OrderState state) {
        this.tickets = tickets;
        this.client = client;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        if(getId()-order.getId()>0)
            return 1;
        else if(getId()-order.getId()<0)
            return -1;
        return 0;
    }
}