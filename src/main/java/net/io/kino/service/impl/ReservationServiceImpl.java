package net.io.kino.service.impl;

import net.io.kino.model.*;
import net.io.kino.repository.OrdersRepository;
import net.io.kino.repository.TicketTypesRepository;
import net.io.kino.service.EmailSender;
import net.io.kino.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private OrdersRepository orders;

    @Autowired
    private TicketTypesRepository ticketTypes;

    @Autowired
    private EmailSender emailSender;

    @Override
    public Order createOrder(List<Ticket> tickets, PersonalDetails client) {
        Order order = new Order(tickets, client, OrderState.inProgress, LocalDateTime.now());
        return orders.save(order);
    }

    @Override
    public boolean confirmOrder(Order order) {
        order.setState(OrderState.paid);
        emailSender.sendEmail(order);
        return orders.save(order) != null;
    }

    @Override
    public boolean cancelOrder(Order order) {
        order.setState(OrderState.cancelled);
        return orders.save(order) != null;
    }

    @Override
    public boolean addTicketType(TicketType type) {
        return ticketTypes.save(type) != null;
    }

    @Override
    public boolean activateTicketType(long id) {
        Optional<TicketType> temp = ticketTypes.findById(id);
        if (temp.isPresent() && !temp.get().getState()) {
            temp.get().setState(true);
            return true;
        } else return false;
    }

    @Override
    public boolean deactivateTicketType(long id) {
        Optional<TicketType> temp = ticketTypes.findById(id);
        if (temp.isPresent() && temp.get().getState()) {
            temp.get().setState(false);
            return true;
        } else return false;
    }

    @Override
    public Optional<Order> findOrderById(long id) {
        return orders.findById(id);
    }

    @Override
    public Optional<TicketType> findTicketTypeById(long id) {
        return ticketTypes.findById(id);
    }

    @Override
    public List<TicketType> getTicketTypes() {
        return ticketTypes.findAll();
    }

    @Override
    public List<Order> getOrdersBetweenDates(LocalDate fromDate, LocalDate toDate) {
        LocalDateTime from = fromDate.atStartOfDay();
        LocalDateTime to = toDate.atTime(23, 59, 59);
        return orders.findOrdersByDateBetween(from,to);
    }

    @Override
    public List<Order> getOrders() {
        return orders.findAll();
    }

}
