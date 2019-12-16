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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    ReservationService reservationService;

    @PostMapping
    public Order addOrder(@RequestBody OrderRequest orderRequest) {
        reservationService.createOrder(orderRequest.getTickets()
                .stream().map(t -> t.convertToTicket(new Showtime())) //TODO: Get showtime from service
                .collect(Collectors.toList()), orderRequest.getClient());
        return new Order();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return reservationService.getOrders().stream().filter(o -> o.getId() == id)
                .findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public List<Order> getOrders(@RequestParam LocalDate fromDate, @RequestParam LocalDate toDate) {
        return reservationService.getOrders();
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<HttpStatus> cancelOrder(@PathVariable Long orderId) {
        Order order = reservationService.getOrders().stream().filter(o -> o.getId() == orderId)
                .findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        reservationService.cancelOrder(order);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
