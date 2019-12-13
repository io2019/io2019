package net.io.kino.service.impl;

import net.io.kino.model.*;
import net.io.kino.repository.OrdersRepository;
import net.io.kino.repository.TicketTypesRepository;
import net.io.kino.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
//todo paypal, uporządkowanie maila (stworzenie nowej klasy+ udostęnienie metod statycznych)
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private OrdersRepository orders;

    @Autowired
    private TicketTypesRepository ticketTypes;

    @Override
    public boolean createOrder(List<Ticket> tickets, PersonalDetails client) {
        Order order = new Order(tickets,client, OrderState.wTrakcieRealizacji);
        return orders.save(order)!=null;
    }

    @Override
    public boolean confirmOrder(Order order) {
        order.setState(OrderState.oplacone);
        return orders.save(order)!=null;
    }

    @Override
    public boolean cancelOrder(Order order) {
        order.setState(OrderState.anulowane);
        return orders.save(order)!=null;
    }

    @Override
    public boolean addTicketType(TicketType type) {
        return ticketTypes.save(type)!=null;
    }

    @Override
    public boolean updateTicketTypeByID(Long id) {
        Optional<TicketType> temp = ticketTypes.findById(id);
        if(temp.isPresent())
        {
            temp.get().setState(!temp.get().getState());
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
