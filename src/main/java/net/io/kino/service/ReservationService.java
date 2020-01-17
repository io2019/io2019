package net.io.kino.service;

import net.io.kino.model.Order;
import net.io.kino.model.PersonalDetails;
import net.io.kino.model.Ticket;
import net.io.kino.model.TicketType;

import java.util.List;

public interface ReservationService {
    boolean createOrder(List<Ticket> tickets, PersonalDetails client);

    boolean confirmOrder(Order order);

    boolean cancelOrder(Order order);

    boolean addTicketType(TicketType type);

    boolean activateTicketType(long id);

    boolean deactivateTicketType(long id);

    List<TicketType> getTicketTypes();

    List<Order> getOrders();
}
