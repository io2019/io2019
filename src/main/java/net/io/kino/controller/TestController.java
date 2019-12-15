package net.io.kino.controller;

import net.io.kino.model.Order;
import net.io.kino.model.Seat;
import net.io.kino.repository.OrdersRepository;
import net.io.kino.repository.SeatRepository;
import net.io.kino.service.EmailSender;
import net.io.kino.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/orders")
public class TestController {

    @Autowired
    private SeatRepository seats;

    @Autowired
    private OrdersRepository orders;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EmailSender emailSender;

    private final Random random = new Random();

    @GetMapping
    public List<Order> all() {
        return orders.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> get(@PathVariable long id) {
        return orders.findById(id);
    }

    @PatchMapping("/{id}")
    public Optional<Order> confirm(@PathVariable long id) {
        Optional<Order> order = orders.findById(id);
        order.ifPresent(value -> reservationService.confirmOrder(value));
        return order;
    }

    @PostMapping
    public Order add(String email) {
        Seat seat = new Seat(random.nextInt());
        seats.save(seat);
        Order order = new Order(email);
        orders.save(order);
        return order;
    }

    @RequestMapping(value = "/sendemail")
    public String sendEmail(String email) {
        Order order = new Order(email);
        emailSender.sendEmail(order);
        return "Email sent successfully";
    }
}
