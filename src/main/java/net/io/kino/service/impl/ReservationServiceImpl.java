package net.io.kino.service.impl;

import net.io.kino.model.*;
import net.io.kino.repository.OrdersRepository;
import net.io.kino.repository.TicketTypesRepository;
import net.io.kino.service.EmailSender;
import net.io.kino.service.ReservationService;
import net.io.kino.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private TicketService ticketService = new TicketServiceImpl();

//todo czy bilet ma byc zapiswany w bazie przy tworzeniu zamówienia czy przy potwierdzeniu zamówienia
    @Override
    public boolean createOrder(List<Ticket> tickets, PersonalDetails client) {
        Order order = new Order(tickets,client, OrderState.inProgress);
        return orders.save(order)!=null;
    }

    @Override
    public boolean confirmOrder(Order order) {
        order.setState(OrderState.paid);
        for (Ticket ticket:order.getTickets()) {
            ticketService.confirmTicket(ticket);
        }
        emailSender.sendEmail(order.getClient().getEmail(),order);
        return orders.save(order)!=null;
    }

    @Override
    public boolean cancelOrder(Order order) {
        order.setState(OrderState.cancelled);
        order.getTickets().clear();
        return orders.save(order)!=null;
    }

    @Override
    public boolean addTicketType(TicketType type) {
        return ticketTypes.save(type)!=null;
    }

    @Override
    public boolean activateTicketType(long id) {
        Optional<TicketType> temp = ticketTypes.findById(id);
        if(temp.isPresent() && !temp.get().getState())
        {
            temp.get().setState(true);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deactivateTicketType(long id) {
        Optional<TicketType> temp = ticketTypes.findById(id);
        if(temp.isPresent() && temp.get().getState())
        {
            temp.get().setState(false);
            return true;
        }
        else return false;
    }

    @Override
    public List<TicketType> getTicketTypes() {
        return ticketTypes.findAll();
    }

    @Override
    public List<Order> getOrders() {
        return orders.findAll();
    }
}
