package net.io.kino.controller;

import net.io.kino.controller.converter.StringToDateConverter;
import net.io.kino.controller.dto.OrderRequest;
import net.io.kino.model.*;
import net.io.kino.service.EmailSender;
import net.io.kino.service.ReservationService;
import net.io.kino.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    ReservationService reservationService;
    ShowtimeService showtimeService;

    @PostMapping
    public Order addOrder(@RequestBody OrderRequest orderRequest) {
        return reservationService.createOrder(orderRequest.getTickets()
                .stream().map(t -> t.convertToTicket(showtimeService.findShowtimeById(t.getShowtimeId())))
                .collect(Collectors.toList()), orderRequest.getClient());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        Optional<Order> order = reservationService.findOrderById(id);
        if (!order.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        reservationService.confirmOrder(order.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        Optional<Order> order = reservationService.findOrderById(id);
        if (!order.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return order.get();
    }

    @GetMapping("/date")
    public List<Order> getOrdersBetweenDates(@RequestParam(name = "fromDate") String from,
                                        @RequestParam(name = "toDate") String to){
        StringToDateConverter converter = new StringToDateConverter();
        LocalDate fromDate = converter.convert(from);
        LocalDate toDate = converter.convert(to);
        return reservationService.getOrdersBetweenDates(fromDate, toDate);
    }

    @GetMapping("/")
    public List<Order> getOrders(){
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
