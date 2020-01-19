package net.io.kino.service.impl;

import com.braintreepayments.http.HttpResponse;
import com.braintreepayments.http.serializer.Json;
import com.paypal.orders.OrdersGetRequest;
import com.paypal.orders.PurchaseUnit;
import net.io.kino.model.*;
import net.io.kino.repository.OrdersRepository;
import net.io.kino.repository.TicketTypesRepository;
import net.io.kino.service.EmailSender;
import net.io.kino.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ReservationServiceImpl extends PayPalClientServiceImpl implements ReservationService {

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
    public boolean verifyOrder(Order order) {
        OrdersGetRequest request = new OrdersGetRequest(String.valueOf(order.getTransactionId()));
        HttpResponse<com.paypal.orders.Order> response = null;
        try {
            response = client().execute(request);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        double paid = 0;
        for (PurchaseUnit pu :response.result().purchaseUnits()) {
            paid += Double.parseDouble(pu.amount().value());
        }
        double orderValue = 0 ;
        for (Ticket t:order.getTickets()) {
            orderValue+=t.getTicketType().getPrice();
        }

        if (response.result().status().equals("COMPLETED") && paid == orderValue ) {
            confirmOrder(order);
            return true;
        } else {
            cancelOrder(order);
            return false;
        }


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
        return orders.findOrdersByDateBetween(from, to);
    }

    @Override
    public List<Order> getOrders() {
        return orders.findAll();
    }

}
