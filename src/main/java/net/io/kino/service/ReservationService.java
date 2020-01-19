package net.io.kino.service;

import net.io.kino.model.Order;
import net.io.kino.model.PersonalDetails;
import net.io.kino.model.Ticket;
import net.io.kino.model.TicketType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Order createOrder(List<Ticket> tickets, PersonalDetails client);

    boolean verifyOrder(Order order);

    boolean confirmOrder(Order order);

    boolean cancelOrder(Order order);

    boolean addTicketType(TicketType type);

    boolean activateTicketType(long id);

    boolean deactivateTicketType(long id);

    Optional<Order> findOrderById(long id);

    Optional<TicketType> findTicketTypeById(long id);

    List<TicketType> getTicketTypes();

    List<Order> getOrdersBetweenDates(LocalDate fromDate, LocalDate toDate);

    List<Order> getOrders();


}
