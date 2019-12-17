package net.io.kino.controller;

import net.io.kino.controller.dto.OrderRequest;
import net.io.kino.model.Order;
import net.io.kino.model.Showtime;
import net.io.kino.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    ReservationService reservationService;

    @PostMapping
    public Order addOrder(@RequestBody OrderRequest orderRequest) {
        return reservationService.createOrder(orderRequest.getTickets()
                .stream().map(t -> t.convertToTicket(new Showtime())) //TODO: Get showtime from service
                .collect(Collectors.toList()), orderRequest.getClient());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        Optional<Order> order = reservationService.findOrderById(id);
        if (!order.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return order.get();
    }

    @GetMapping("/")
    public List<Order> getOrders(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
        return reservationService.getOrders();
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<HttpStatus> cancelOrder(@PathVariable Long orderId) {
        Optional<Order> order = reservationService.findOrderById(orderId);
        if (!order.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        reservationService.cancelOrder(order.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}